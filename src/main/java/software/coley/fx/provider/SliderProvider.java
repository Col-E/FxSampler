package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class SliderProvider implements VariableControlProvider {
	@Override
	public Label key() {
		return new Label("Slider");
	}

	@Override
	public void accept(GridPane grid, int row) {
		int col = 0;
		int width = 2;
		// First slider
		Slider slider = new Slider(0, 100, 50);
		grid.add(slider, col, row, width, 1);
		// Second slider
		slider = new Slider(0, 100, 50);
		slider.getStyleClass().add("thick-slider");
		grid.add(slider, col += width, row, width, 1);
	}
}
