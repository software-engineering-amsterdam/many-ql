package ql.gui.screen;

import javax.swing.JComponent;

import ql.Value;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public abstract class Screen implements UIComponent {
	private Panel screen;
	private UIComponent handler;
	
	public Screen() {
		screen = new Panel(this);
	}
	
	public void addScreenSection(Panel screenSection) {		
		screen.addComponent(screenSection);
		screenSection.setHandler(this);
	}
	
	public Panel getScreen() {
		return screen;
	}
	
	public void hideScreen() {
		screen.getComponent().setVisible(false);
	}
	
	public void showScreen() {
		screen.getComponent().setVisible(true);
	}
	
	@Override
	public void updateComponent() {
		screen.updateComponent();
	}

	@Override
	public JComponent getComponent() {
		return screen.getComponent();
	}
	
	@Override
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		handler.handleChange(changedValue, source);
	}
}
