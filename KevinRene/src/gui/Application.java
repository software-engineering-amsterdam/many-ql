package gui;

import gui.screen.FileLoaderScreen;
import gui.structure.Panel;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ql.TypeEnvironment;
import ql.Value;
import ql.ValueEnvironment;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

public class Application extends UIComponent {
	private JFrame frame;
	
	private FileLoaderScreen fileSelectionMenu;
	
	private Panel activePanel, fileSelectionPanel;
	private UIComponent formContent;
	
	public Application(JFrame frame) {
		this.frame = frame;
		
		fileSelectionMenu = new FileLoaderScreen();
				
		fileSelectionPanel = new Panel(this);		
		fileSelectionPanel.addComponent(fileSelectionMenu);
		
		activePanel = new Panel(this);
		activePanel.addComponent(fileSelectionPanel);
		
		frame.getContentPane().add(activePanel.getComponent());
	}

	private UIComponent createFormPanel(String formCode) throws ClassCastException {
        QLNode tree = Parser.parse(formCode);
        
		if(!TypeChecker.check((Statement) tree, new TypeEnvironment())) {
			fileSelectionMenu.addLogMessage("Type error detected in the form.");
		}
		
		return ComponentCreator.check((Statement) tree, new ValueEnvironment());
	}
	
	public void activateFormPanel() {
		formContent.getComponent().setVisible(true);
		formContent.updateComponent();
		
		fileSelectionPanel.getComponent().setVisible(false);
		fileSelectionPanel.updateComponent();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		if(source == fileSelectionMenu) {
			try {
				formContent = createFormPanel(fileSelectionMenu.getFileLines());
				activePanel.addComponent(formContent);
				activateFormPanel();
			} catch(ClassCastException exception) {
				fileSelectionMenu.addLogMessage("QL file is not a valid form.");
			}
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
