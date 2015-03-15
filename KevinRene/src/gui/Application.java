package gui;

import gui.screen.FormLoaderScreen;
import gui.screen.FormScreen;
import gui.structure.Page;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ql.Value;
import ql.ast.Statement;

public class Application extends UIComponent {
	private JFrame frame;
	
	private FormLoaderScreen fileLoaderScreen;
	private FormScreen formScreen;
	
	private Page activePanel;
	
	public Application(JFrame frame) {
		this.frame = frame;
		
		fileLoaderScreen = new FormLoaderScreen(this);
		
		activePanel = new Page(this);
		activePanel.addSection(fileLoaderScreen.getScreen());
		
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
			activePanel.addSection(formScreen.getScreen());
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
}
