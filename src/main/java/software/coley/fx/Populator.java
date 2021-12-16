package software.coley.fx;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import software.coley.fx.provider.ButtonProvider;
import software.coley.fx.provider.CheckboxProvider;
import software.coley.fx.provider.ColumnControlProvider;
import software.coley.fx.provider.ComboboxProvider;
import software.coley.fx.provider.LabelProvider;
import software.coley.fx.provider.ListProvider;
import software.coley.fx.provider.ProgressProvider;
import software.coley.fx.provider.RadioProvider;
import software.coley.fx.provider.SliderProvider;
import software.coley.fx.provider.SpinnerProvider;
import software.coley.fx.provider.TableProvider;
import software.coley.fx.provider.TabsProvider;
import software.coley.fx.provider.TextfieldProvider;
import software.coley.fx.provider.TreeProvider;
import software.coley.fx.provider.VariableControlProvider;
import software.coley.fx.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Populates the UI.
 *
 * @author Matt Coley
 */
public class Populator {
	private static final List<ColumnControlProvider<?>> COLUMN_CONTROL_PROVIDERS = new ArrayList<>();
	private static final List<VariableControlProvider> VARIABLE_CONTROL_PROVIDERS = new ArrayList<>();
	private static final Column[] COLUMNS = Column.values();
	private static final int MAX_WIDTH = 120;

	/**
	 * @param stage
	 * 		Stage to create a scene for containing controls.
	 */
	public static void apply(Stage stage) {
		BorderPane root = new BorderPane();
		populateMenu(stage, root);
		populateControls(root);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setWidth(800);
		stage.setHeight(400);
	}

	/**
	 * @param stage
	 * 		Stage to apply menu to.
	 * @param root
	 * 		Root to add the menu to.
	 */
	private static void populateMenu(Stage stage, BorderPane root) {
		MenuBar menuBar = new MenuBar();

		Menu fileMenu = new Menu("File");
		Menu miscMenu = new Menu("Misc");
		Menu helpMenu = new Menu("Help");

		MenuItem setStyle = new MenuItem("Set stylesheet");
		setStyle.setOnAction(e -> FileUtil.setStyle(stage, menuBar.getScene()));
		fileMenu.getItems().add(setStyle);

		miscMenu.getItems().add(new CheckMenuItem("Checked item"));
		miscMenu.getItems().add(new SeparatorMenuItem());
		miscMenu.getItems().add(new RadioMenuItem("Radio item"));

		MenuItem openGithub = new MenuItem("GitHub");
		openGithub.setOnAction(e -> FileUtil.browse(FxSampler.GIHUB_URL));
		helpMenu.getItems().add(openGithub);

		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(miscMenu);
		menuBar.getMenus().add(helpMenu);

		root.setTop(menuBar);
	}

	/**
	 * @param root
	 * 		Root to add controls to.
	 */
	private static void populateControls(BorderPane root) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(15);
		grid.setHgap(30);
		int row = 0;
		for (ColumnControlProvider<?> provider : COLUMN_CONTROL_PROVIDERS) {
			int col = 0;
			Node[] children = new Node[COLUMNS.length + 1];
			children[0] = provider.key();
			for (Column column : COLUMNS) {
				Node child = provider.create(column);
				if (child == null)
					child = new Label();
				if (child instanceof Region)
					((Region) child).setMaxWidth(MAX_WIDTH);
				children[++col] = child;
			}
			grid.addRow(row++, children);
		}
		for (VariableControlProvider provider : VARIABLE_CONTROL_PROVIDERS) {
			provider.accept(grid, row++);
		}
		root.setCenter(new ScrollPane(grid));
	}

	static {
		COLUMN_CONTROL_PROVIDERS.add(new LabelProvider());
		COLUMN_CONTROL_PROVIDERS.add(new ButtonProvider());
		COLUMN_CONTROL_PROVIDERS.add(new CheckboxProvider());
		COLUMN_CONTROL_PROVIDERS.add(new RadioProvider());
		COLUMN_CONTROL_PROVIDERS.add(new ComboboxProvider());
		COLUMN_CONTROL_PROVIDERS.add(new SpinnerProvider());
		COLUMN_CONTROL_PROVIDERS.add(new TextfieldProvider());
		VARIABLE_CONTROL_PROVIDERS.add(new TabsProvider());
		VARIABLE_CONTROL_PROVIDERS.add(new SliderProvider());
		VARIABLE_CONTROL_PROVIDERS.add(new ProgressProvider(false));
		VARIABLE_CONTROL_PROVIDERS.add(new ProgressProvider(true));
		VARIABLE_CONTROL_PROVIDERS.add(new TableProvider());
		VARIABLE_CONTROL_PROVIDERS.add(new ListProvider());
		VARIABLE_CONTROL_PROVIDERS.add(new TreeProvider());
	}
}
