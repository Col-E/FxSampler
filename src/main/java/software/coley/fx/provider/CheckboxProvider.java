package software.coley.fx.provider;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import software.coley.fx.Column;

public class CheckboxProvider implements ColumnControlProvider<CheckBox> {
	@Override
	public Label key() {
		return new Label("CheckBox");
	}

	@Override
	public CheckBox create(Column column) {
		switch (column) {
			case ENABLED:
				return new CheckBox("Enabled");
			case DISABLED:
				CheckBox disabled = new CheckBox("Disabled");
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
				CheckBox variant1 = new CheckBox("Selected");
				variant1.setSelected(true);
				return variant1;
			case ALT_VARIANT_2:
				CheckBox variant2 = new CheckBox("Selected");
				variant2.setSelected(true);
				variant2.setDisable(true);
				return variant2;
			default:
				return null;
		}
	}
}
