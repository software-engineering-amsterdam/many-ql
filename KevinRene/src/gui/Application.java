package gui;

import gui.menu.FileSelectionMenu;
import gui.widget.composite.Panel;

import javax.swing.JComponent;
import javax.swing.JFrame;

import ql.TypeEnvironment;
import ql.Value;
import ql.ValueEnvironment;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

public class Application extends Composite {
	private JFrame frame;
	
	private FileSelectionMenu fileSelectionMenu;
	
	private Panel activePanel, fileSelectionPanel;
	private Widget formContent;
	
	public Application(JFrame frame) {
		super(new Identifier("Application"));
				
		this.frame = frame;
		
		fileSelectionMenu = new FileSelectionMenu();
				
		fileSelectionPanel = new Panel();		
		fileSelectionPanel.addComponent(fileSelectionMenu);
		fileSelectionPanel.setHandler(this);
		
		activePanel = new Panel();
		activePanel.addComponent(fileSelectionPanel);
		activePanel.setHandler(this);
		
		frame.getContentPane().add(activePanel.getComponent());
	}

	private Widget createFormPanel(String formCode) throws ClassCastException {
        Parser formParser = new Parser();
        QLNode tree = formParser.parse(formCode);
        
		if(!TypeChecker.check((Statement) tree, new TypeEnvironment())) {
			fileSelectionMenu.addLogMessage("Type error detected in the form.\n");
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
	public void handleChange(Value changedValue, Widget source) {
		if(source == fileSelectionMenu) {
			try {
				formContent = createFormPanel(fileSelectionMenu.getFileLines());
				activePanel.addComponent(formContent);
				activateFormPanel();
			} catch(ClassCastException exception) {
				fileSelectionMenu.addLogMessage("QL file is not a valid form.\n");
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
