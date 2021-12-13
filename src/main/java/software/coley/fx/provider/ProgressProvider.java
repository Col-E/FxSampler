package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

public class ProgressProvider implements VariableControlProvider {
	private final boolean disabled;

	public ProgressProvider(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public Label key() {
		return new Label("ProgressBar");
	}

	@Override
	public void accept(GridPane grid, int row) {
		int col = 0;
		int width = 1;
		// First bar
		ProgressBar progress = new ProgressBar(0);
		progress.setDisable(disabled);
		grid.add(progress, col, row, width, 1);
		// Second bar
		progress = new ProgressBar(0.25);
		progress.setDisable(disabled);
		grid.add(progress, col += width, row, width, 1);
		// Third bar
		progress = new ProgressBar(0.5);
		progress.setDisable(disabled);
		progress.getStyleClass().add("thick-progress");
		grid.add(progress, col += width, row, width, 1);
		// 4th bar
		progress = new ProgressBar(1);
		progress.setDisable(disabled);
		progress.getStyleClass().add("thick-progress");
		grid.add(progress, col += width, row, width, 1);
	}
}
