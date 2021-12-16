package software.coley.fx.provider;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.util.List;

public class TableProvider implements VariableControlProvider {
	private static final ObservableList<String> list = FXCollections.observableList(List.of("a", "b", "c"));

	@Override
	public Label key() {
		return new Label("TableView");
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void accept(GridPane grid, int row) {
		int col = 0;
		int width = 2;
		// First view
		TableView<String> view = new TableView<>(list);
		view.getColumns().add(new TableColumn<>("Column 1"));
		view.getColumns().add(new TableColumn<>("Column 2"));
		view.getColumns().add(new TableColumn<>("Column 3"));
		view.getColumns().forEach(c -> c.setCellValueFactory(data -> new SimpleObjectProperty("Lorem ipsum")));
		view.setMaxHeight(250);
		grid.add(view, col, row, width, 1);
		// Second view
		view = new TableView<>(list);
		view.getColumns().add(new TableColumn<>("Column 1"));
		view.getColumns().add(new TableColumn<>("Column 2"));
		view.getColumns().forEach(c -> c.setCellValueFactory(data -> new SimpleObjectProperty("Lorem ipsum")));
		view.setMaxHeight(250);
		view.setDisable(true);
		grid.add(view, col += width, row, width, 1);
	}
}
