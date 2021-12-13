package software.coley.fx.provider;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

public class TabsProvider implements VariableControlProvider {
	@Override
	public Label key() {
		return new Label("TabPane");
	}

	@Override
	public void accept(GridPane grid, int row) {
		TabPane tabs = new TabPane();
		Tab closableTab = new Tab("Closable tab");
		tabs.getTabs().add(new Tab("Normal tab 1"));
		tabs.getTabs().add(new Tab("Normal tab 2"));
		tabs.getTabs().add(new Tab("Normal tab 3"));
		tabs.getTabs().add(closableTab);
		for (Tab tab : tabs.getTabs())
			tab.setClosable(false);
		closableTab.setClosable(true);
		grid.add(tabs, 0, row, 4, 1);
	}
}
