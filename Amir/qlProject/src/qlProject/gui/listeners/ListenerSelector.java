package qlProject.gui.listeners;

import java.util.Map;

import javax.swing.JComponent;

import qlProject.ast.statement.IStatementsVisitor;
import qlProject.gui.InputInterpreter;
import qlProject.gui.gui_building_visitors.QuestionWidget;

public abstract class ListenerSelector implements IStatementsVisitor{

	protected InputInterpreter interpreter;
	protected String observed;
	protected JComponent observedComponent;

	public ListenerSelector(InputInterpreter interpreter, Map<String, QuestionWidget> questionWidgetsMap, String observed){
		this.interpreter = interpreter;
		this.observed = observed;
		this.observedComponent =  questionWidgetsMap.get(observed).getComponent();
	}
}