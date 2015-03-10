package gui.screen;

import gui.UIComponent;

import javax.swing.JComponent;

public class FormScreen extends UIComponent {
	private UIComponent widgetPanel;
	
	public FormScreen(UIComponent widgetPanel) {
		this.widgetPanel = widgetPanel;
		this.widgetPanel.setHandler(this);
	}

	@Override
	public void updateComponent() {
		widgetPanel.updateComponent();
	}
	
	@Override
	public JComponent getComponent() {
		return widgetPanel.getComponent();
	}	
}
