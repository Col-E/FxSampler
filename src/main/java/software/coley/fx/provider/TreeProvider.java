package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;

public class TreeProvider implements VariableControlProvider {
	private static final TreeItem<String> root = new TreeItem<>("Root");

	static {
		root.setExpanded(true);
		root.getChildren().add(new TreeItem<>("Child 1"));
		root.getChildren().add(new TreeItem<>("Child 2"));
		root.getChildren().add(new TreeItem<>("Child 3"));
		root.getChildren().add(new TreeItem<>("Child 4"));
		root.getChildren().add(new TreeItem<>("Child 5"));
	}

	@Override
	public Label key() {
		return new Label("TreeView");
	}

	@Override
	public void accept(GridPane grid, int row) {
		int col = 0;
		int width = 2;
		// First view
		TreeView<String> view = new TreeView<>(root);
		grid.add(view, col, row, width, 1);
		// Second view
		view = new TreeView<>(root);
		view.setDisable(true);
		grid.add(view, col += width, row, width, 1);
	}
}
