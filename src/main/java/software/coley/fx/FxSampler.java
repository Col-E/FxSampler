package software.coley.fx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main entrypoint to display the window.
 *
 * @author Matt Coley
 */
public class FxSampler {
	public static final String GIHUB_URL = "https://github.com/Col-E/FxSampler";

	/**
	 * @param args
	 * 		Program args, unused.
	 */
	public static void main(String[] args) {
		AppImpl.launch(AppImpl.class, args);
	}

	/**
	 * See: https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing
	 */
	public static class AppImpl extends Application {
		@Override
		public void start(Stage stage) {
			Populator.apply(stage);
			stage.setTitle("FX Sampler");
			stage.show();
		}
	}
}