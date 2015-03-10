package gui.screen;

import gui.Composite;
import gui.Widget;

import javax.swing.JComponent;

import ql.ast.expression.Identifier;

public class FormScreen extends Composite {
	private Widget widgetPanel;
	
	public FormScreen(Widget widgetPanel) {
		super(new Identifier("Form"));
		
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
