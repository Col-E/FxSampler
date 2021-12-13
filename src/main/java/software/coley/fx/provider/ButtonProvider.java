package software.coley.fx.provider;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import software.coley.fx.Column;

public class ButtonProvider implements ColumnControlProvider<Button> {
	@Override
	public Label key() {
		return new Label("Button");
	}

	@Override
	public Button create(Column column) {
		switch (column) {
			case ENABLED:
				return new Button("Enabled");
			case DISABLED:
				Button disabled = new Button("Disabled");
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
				Button variant1 = new Button("Square");
				variant1.getStyleClass().add("square");
				return variant1;
			case ALT_VARIANT_2:
				Button variant2 = new Button("Round");
				variant2.getStyleClass().add("round");
				return variant2;
			default:
				return null;
		}
	}
}
