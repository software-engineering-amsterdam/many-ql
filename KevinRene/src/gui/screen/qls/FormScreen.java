package gui.screen.qls;

import gui.Screen;
import ql.ValueEnvironment;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.gui.ComponentCreator;
import ql.gui.UIComponent;
import ql.gui.structure.ScrollablePanel;
import qls.ast.expression.literal.StringLiteral;
import qls.gui.structure.UISection;


public class FormScreen extends Screen {
	public FormScreen(UIComponent handler, Statement formAst) {
		super(new Identifier("Form"));
		setHandler(handler);
		
		createFormScreen(formAst);	
	}
	
	private void createFormScreen(Statement formAst) {
		UISection formSection = new UISection(new StringLiteral("Form"), this);
		ScrollablePanel scrollable = new ScrollablePanel(ComponentCreator.check(formAst, new ValueEnvironment()));
		
		formSection.addComponent(scrollable);
		
		addSection(formSection);
	}
}
