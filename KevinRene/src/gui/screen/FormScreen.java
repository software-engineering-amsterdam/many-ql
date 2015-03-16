package gui.screen;

import gui.ComponentCreator;
import gui.UIComponent;
import gui.structure.Section;
import ql.ValueEnvironment;
import ql.ast.Statement;

public class FormScreen extends Screen {
	public FormScreen(UIComponent handler, Statement formAst) {
		setHandler(handler);
		
		createFormScreen(formAst);	
	}
	
	private void createFormScreen(Statement formAst) {
		addScreenSection((Section) ComponentCreator.check(formAst, new ValueEnvironment()));
	}
}
