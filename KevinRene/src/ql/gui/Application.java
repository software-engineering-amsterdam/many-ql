package ql.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ql.Value;
import ql.ast.Statement;
import ql.gui.screen.FormLoaderScreen;
import ql.gui.screen.FormScreen;
import ql.gui.structure.Panel;

public class Application implements UIComponent {
	private JFrame frame;
	
	private FormLoaderScreen fileLoaderScreen;
	private FormScreen formScreen;
	
	private Panel activePanel;
	
	public Application(JFrame frame) {
		this.frame = frame;
		
		fileLoaderScreen = new FormLoaderScreen(this);
		
		activePanel = new Panel(this);
		activePanel.addComponent(fileLoaderScreen.getScreen());
		
		frame.getContentPane().add(activePanel.getComponent());
	}
	
	public void activateFormPanel() {
		formScreen.showScreen();
		fileLoaderScreen.hideScreen();
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		if(source == fileLoaderScreen) {
			formScreen = new FormScreen(this, (Statement) fileLoaderScreen.getFormAst());
			activePanel.addComponent(formScreen.getScreen());
			activateFormPanel();
		}
		
		updateComponent();
	}
	
	@Override
	public void updateComponent() {
		activePanel.updateComponent();		
		
		frame.setVisible(true);
	}

	@Override
	public JComponent getComponent() {
		return activePanel.getComponent();
	}

	@Override
	public void setHandler(UIComponent handler) {
		// Handler is not used.
	}
}
