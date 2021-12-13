package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Provider for a varying number of controls.
 *
 * @author Matt Coley
 */
public interface VariableControlProvider {
	/**
	 * @return Label showing the {@code T} type.
	 */
	Label key();

	/**
	 * @param grid
	 * 		Grid to add children to.
	 * @param row
	 * 		Row to add to.
	 */
	void accept(GridPane grid, int row);
}
