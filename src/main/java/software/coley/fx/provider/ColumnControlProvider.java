package software.coley.fx.provider;

import javafx.scene.Node;
import javafx.scene.control.Label;
import software.coley.fx.Column;

/**
 * Provider for controls per {@link Column}.
 *
 * @param <T>
 * 		Node type.
 *
 * @author Matt Coley
 */
public interface ColumnControlProvider<T extends Node> {
	/**
	 * @return Label showing the {@code T} type.
	 */
	Label key();

	/**
	 * @param column
	 * 		Column to place control in.
	 *
	 * @return Control instance for the column.
	 */
	T create(Column column);
}
