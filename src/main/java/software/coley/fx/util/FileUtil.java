package software.coley.fx.util;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Tossed all the IO operations in here.
 *
 * @author Matt Coley
 */
public class FileUtil {
	private static final ExecutorService THREAD_POOL = Executors.newSingleThreadExecutor(FileUtil::newThread);
	private static Future<?> fileWatchThread;

	public static void registerRefreshWatch(Scene scene, Path path) {
		if (fileWatchThread != null) {
			fileWatchThread.cancel(true);
		}
		fileWatchThread = THREAD_POOL.submit(() -> {
			try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
				path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
				while (!Thread.interrupted()) {
					WatchKey wk = watchService.take();
					if (!wk.pollEvents().isEmpty())
						refresh(scene, path);
					if (!wk.reset())
						break;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

	public static void refresh(Scene scene, Path path) {
		if (Files.isRegularFile(path)) {
			path = path.getParent();
		}
		System.out.println("Refresh CSS from path: " + path);
		ObservableList<String> list = scene.getStylesheets();
		try {
			list.setAll(Files.walk(path)
					.map(subpath -> "file:///" + subpath.toFile().getAbsolutePath().replace("\\", "/"))
					.collect(Collectors.toList()));
		} catch (IOException ex) {
			ex.printStackTrace();
			Toolkit.getDefaultToolkit().beep();
		}
	}

	public static void setStyle(Stage stage, Scene scene) {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		chooser.setTitle("Open directory with CSS files");

		File file = chooser.showDialog(stage);

		if (file != null) {
			Path path = file.toPath();
			FileUtil.registerRefreshWatch(scene, path);
			FileUtil.refresh(scene, path);
		}
	}

	public static void browse(String url) {
		new Thread(() -> {
			try {
				Desktop.getDesktop().browse(URI.create(url));
			} catch (IOException ex) {
				ex.printStackTrace();
				Toolkit.getDefaultToolkit().beep();
			}
		}).start();
	}

	private static Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}
