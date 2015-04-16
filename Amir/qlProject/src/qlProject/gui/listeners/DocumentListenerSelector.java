package qlProject.gui.listeners;

import java.util.Map;

import javax.swing.JTextField;

import qlProject.ast.Questionnaire;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.gui.InputInterpreter;
import qlProject.gui.gui_building_visitors.QuestionWidget;
import qlProject.gui.listeners.document_listeners.TextFieldToBasicQuestionListener;
import qlProject.gui.listeners.document_listeners.TextFieldToComputedListener;
import qlProject.gui.listeners.document_listeners.TextFieldToConditionalQuestionsListListener;

public class DocumentListenerSelector extends ListenerSelector implements IStatementsVisitor {

	public DocumentListenerSelector(InputInterpreter interpreter, Map<String, QuestionWidget> questionWidgetsMap, String observed){
		super(interpreter, questionWidgetsMap, observed);
	}


	@Override
	public void visit(Questionnaire q){
		q.accept(this);
	}

	@Override
	public void visit(ComputedAssignment a){
		((JTextField)observedComponent).getDocument().addDocumentListener(new TextFieldToComputedListener(observed, a, interpreter));
	}

	@Override
	public void visit(IfStatement s){
		((JTextField)observedComponent).getDocument().addDocumentListener(new TextFieldToConditionalQuestionsListListener(observed, s, interpreter));
	}

	@Override
	public void visit(DirectAssignment q){
		((JTextField)observedComponent).getDocument().addDocumentListener(new TextFieldToBasicQuestionListener(observed, interpreter));
	}

}