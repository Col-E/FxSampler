package software.coley.fx.provider;

import javafx.scene.control.Label;
import software.coley.fx.Column;

public class LabelProvider implements ColumnControlProvider<Label> {
	@Override
	public Label key() {
		return new Label("Label");
	}

	@Override
	public Label create(Column column) {
		switch (column) {
			case ENABLED:
				return new Label("Enabled");
			case DISABLED:
				Label disabled = new Label("Disabled");
				disabled.setDisable(true);
				return disabled;
			case ALT_VARIANT_1:
			case ALT_VARIANT_2:
			default:
				return null;
		}
	}
}
