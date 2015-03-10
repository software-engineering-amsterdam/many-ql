package gui.screen;

import javax.swing.JComponent;

import gui.UIComponent;
import gui.structure.Section;

public abstract class Screen extends UIComponent {
	private Section screen;
	
	public Screen() {
		screen = new Section(this);
	}
	
	public void addScreenSection(Section screenSection) {		
		screen.addComponent(screenSection);
		screenSection.setHandler(this);
	}
	
	public Section getScreen() {
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
}
