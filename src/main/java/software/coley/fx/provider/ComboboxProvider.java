package software.coley.fx.provider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import software.coley.fx.Column;

import java.util.List;

public class ComboboxProvider implements ColumnControlProvider<ComboBox<String>> {
	private static final ObservableList<String> list = FXCollections.observableList(List.of("Initial", "Second", "Third"));

	@Override
	public Label key() {
		return new Label("ComboBox");
	}

	@Override
	public ComboBox<String> create(Column column) {
		switch (column) {
			case ENABLED:
				ComboBox<String> combo = new ComboBox<>(list);
				combo.getSelectionModel().select(0);
				return combo;
			case DISABLED:
				ComboBox<String> disabled = new ComboBox<>(list);
				disabled.getSelectionModel().select(0);
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
				ComboBox<String> variant1 = new ComboBox<>(list);
				variant1.getSelectionModel().select(0);
				variant1.getStyleClass().add("square");
				return variant1;
			case ALT_VARIANT_2:
				ComboBox<String> variant2 = new ComboBox<>(list);
				variant2.getSelectionModel().select(0);
				variant2.getStyleClass().add("round");
				return variant2;
			default:
				return null;
		}
	}
}
