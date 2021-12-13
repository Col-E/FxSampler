package software.coley.fx.provider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import software.coley.fx.Column;

import java.util.List;

public class SpinnerProvider implements ColumnControlProvider<Spinner<Integer>> {
	private static final ObservableList<Integer> list = FXCollections.observableList(List.of(0, 10, 100, 1000, 10000));

	@Override
	public Label key() {
		return new Label("Spinner");
	}

	@Override
	public Spinner<Integer> create(Column column) {
		switch (column) {
			case ENABLED:
				return new Spinner<>(list);
			case DISABLED:
				Spinner<Integer> disabled = new Spinner<>(list);
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
				Spinner<Integer> variant1 = new Spinner<>(list);
				variant1.getStyleClass().add("square");
				return variant1;
			case ALT_VARIANT_2:
				Spinner<Integer> variant2 = new Spinner<>(list);
				variant2.getStyleClass().add("round");
				return variant2;
			default:
				return null;
		}
	}
}
