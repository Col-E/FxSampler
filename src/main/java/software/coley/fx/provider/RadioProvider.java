package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import software.coley.fx.Column;

public class RadioProvider implements ColumnControlProvider<RadioButton> {
	@Override
	public Label key() {
		return new Label("RadioButton");
	}

	@Override
	public RadioButton create(Column column) {
		switch (column) {
			case ENABLED:
				return new RadioButton("Enabled");
			case DISABLED:
				RadioButton disabled = new RadioButton("Disabled");
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
				RadioButton variant1 = new RadioButton("Selected");
				variant1.setSelected(true);
				return variant1;
			case ALT_VARIANT_2:
				RadioButton variant2 = new RadioButton("Selected");
				variant2.setSelected(true);
				variant2.setDisable(true);
				return variant2;
			default:
				return null;
		}
	}
}
