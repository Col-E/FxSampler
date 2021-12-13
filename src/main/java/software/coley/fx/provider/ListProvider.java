package software.coley.fx.provider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.util.List;

public class ListProvider implements VariableControlProvider {
	private static final ObservableList<String> list = FXCollections.observableList(List.of(
			"Item 1", "Item 2", "Item 3",
			"Item 4", "Item 5", "Item 6",
			"Item 7", "Item 8", "Item 9"));

	@Override
	public Label key() {
		return new Label("ListView");
	}

	@Override
	public void accept(GridPane grid, int row) {
		int col = 0;
		int width = 2;
		// First view
		ListView<String> view = new ListView<>(list);
		grid.add(view, col, row, width, 1);
		// Second view
		view = new ListView<>(list);
		view.setDisable(true);
		grid.add(view, col += width, row, width, 1);
	}
}
