package gui;

import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ql.Value;
import ql.ast.expression.Identifier;
import ql.ast.statement.Form;
import ql.gui.Component;
import qls.gui.structure.TabbedPanel;

public class Application implements Component {
	private JFrame frame;
	private TabbedPanel tabbedPanel;
	
	private gui.screen.ql.SelectionScreen qlSelectionScreen;
	private gui.screen.ql.FormScreen qlFormScreen;
	
	private gui.screen.qls.SelectionScreen qlsSelectionScreen;
	
	public Application(JFrame frame) {
		this.frame = frame;
		tabbedPanel = new TabbedPanel(new Identifier("Application"), Arrays.asList());
		tabbedPanel.setHandler(this);
		
		qlSelectionScreen = new gui.screen.ql.SelectionScreen(this);
		qlsSelectionScreen = new gui.screen.qls.SelectionScreen(this);
		
		tabbedPanel.setPages(Arrays.asList(qlSelectionScreen, qlsSelectionScreen));
		
		frame.getContentPane().add(tabbedPanel.getComponent());
	}
	
	@Override
	public void handleChange(Value changedValue, Component source) {
		if(source == qlSelectionScreen) {
			qlFormScreen = new gui.screen.ql.FormScreen(this, (Form) qlSelectionScreen.getFormAst());
			tabbedPanel.addPage(qlFormScreen.getScreen());
		}
		
		if(source == qlsSelectionScreen) {
			tabbedPanel.addPage(qlsSelectionScreen.getQLSInterface());
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
	public void setHandler(Component handler) {
		// Handler is not used.
	}
}
