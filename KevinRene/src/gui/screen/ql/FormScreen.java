package gui.screen.ql;

import gui.Screen;
import ql.ast.Statement;
import ql.ast.statement.Form;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.ComponentCreator;
import ql.gui.Component;
import ql.gui.structure.ScrollablePanel;
import qls.ast.expression.literal.StringLiteral;
import qls.gui.structure.UISection;

public class FormScreen extends Screen {
	public FormScreen(Component handler, Form formAst) {
		super(formAst.getIdentifier());
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
