package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import software.coley.fx.Column;

public class TextfieldProvider implements ColumnControlProvider<TextField> {
	@Override
	public Label key() {
		return new Label("TextField");
	}

	@Override
	public TextField create(Column column) {
		switch (column) {
			case ENABLED:
				TextField text = new TextField("Enabled");
				return text;
			case DISABLED:
				TextField disabled = new TextField("Disabled");
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
				TextField variant1 = new TextField("Not editable");
				variant1.setEditable(false);
				variant1.getStyleClass().add("square");
				return variant1;
			case ALT_VARIANT_2:
				TextField variant2 = new TextField("Not editable");
				variant2.setEditable(false);
				variant2.getStyleClass().add("round");
				return variant2;
			default:
				return null;
		}
	}
}
