package qlProject.gui.listeners;

import java.util.Map;

import javax.swing.JCheckBox;

import qlProject.ast.Questionnaire;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.gui.InputInterpreter;
import qlProject.gui.gui_building_visitors.QuestionWidget;
import qlProject.gui.listeners.item_listeners.CheckBoxToBasicQuestionListener;
import qlProject.gui.listeners.item_listeners.CheckBoxToComputedListener;
import qlProject.gui.listeners.item_listeners.CheckBoxToConditionalQuestionsListListener;

public class ItemListenerSelector extends ListenerSelector{

	private JCheckBox observedCB;
	
	public ItemListenerSelector(InputInterpreter interpreter,
			Map<String, QuestionWidget> questionWidgetsMap, String observed) {
		super(interpreter, questionWidgetsMap, observed);
		this.observedCB = (JCheckBox)observedComponent;
	}


	@Override
	public void visit(ComputedAssignment question){
		observedCB.addItemListener(new CheckBoxToComputedListener(observed, question, interpreter));
	}
	
	@Override
	public void visit(IfStatement ifStatement){
		observedCB.addItemListener(new CheckBoxToConditionalQuestionsListListener(observed, ifStatement, interpreter));
	}

	@Override
	public void visit(DirectAssignment question){
		observedCB.addItemListener(new CheckBoxToBasicQuestionListener(observed, interpreter));
	}

	@Override
	public void visit(Questionnaire questionnaire) {
		questionnaire.accept(this);
	}

}