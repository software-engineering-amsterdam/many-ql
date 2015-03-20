package gui;

import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ql.Value;
import ql.ast.Statement;
import ql.ast.statement.Form;
import ql.gui.UIComponent;
import qls.gui.structure.TabbedPanel;

public class Application implements UIComponent {
	private JFrame frame;
	private TabbedPanel tabbedPanel;
	
	private gui.screen.ql.SelectionScreen qlSelectionScreen;
	private gui.screen.ql.FormScreen qlFormScreen;
	
	private gui.screen.qls.SelectionScreen qlsSelectionScreen;
	private gui.screen.qls.FormScreen qlsFormScreen;
	
	public Application(JFrame frame) {
		this.frame = frame;
		tabbedPanel = new TabbedPanel(Arrays.asList());
		tabbedPanel.setHandler(this);
		
		qlSelectionScreen = new gui.screen.ql.SelectionScreen(this);
		qlsSelectionScreen = new gui.screen.qls.SelectionScreen(this);
		
		tabbedPanel.setPages(Arrays.asList(qlSelectionScreen, qlsSelectionScreen));
		
		frame.getContentPane().add(tabbedPanel.getComponent());
	}
	
	public void activateFormPanel() {
		qlFormScreen.showScreen();
		qlSelectionScreen.hideScreen();
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		if(source == qlSelectionScreen) {
			qlFormScreen = new gui.screen.ql.FormScreen(this, (Form) qlSelectionScreen.getFormAst());
			tabbedPanel.addPage(qlFormScreen.getScreen());
			activateFormPanel();
		}
		
		if(source == qlsSelectionScreen) {
			qlsFormScreen = new gui.screen.qls.FormScreen(this, (Statement) qlSelectionScreen.getFormAst());
			tabbedPanel.addPage(qlsFormScreen.getScreen());
			activateFormPanel();
		}
		
		updateComponent();
	}
	
	@Override
	public void updateComponent() {
		tabbedPanel.updateComponent();
		frame.setVisible(true);
	}

	@Override
	public JComponent getComponent() {
		return tabbedPanel.getComponent();
	}

	@Override
	public void setHandler(UIComponent handler) {
		// Handler is not used.
	}
}
