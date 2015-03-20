package ql.gui.screen;

import ql.ValueEnvironment;
import ql.ast.Statement;
import ql.gui.ComponentCreator;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public class FormScreen extends Screen {
	public FormScreen(UIComponent handler, Statement formAst) {
		setHandler(handler);
		
		createFormScreen(formAst);	
	}
	
	private void createFormScreen(Statement formAst) {
		addScreenSection((Panel) ComponentCreator.check(formAst, new ValueEnvironment()));
	}
}
