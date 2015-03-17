package uva.sc.ql.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;

import org.antlr.v4.runtime.RecognitionException;

import uva.sc.ql.dependentElements.DependentQuestionsVisitor;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.form.Form;
import uva.sc.ql.gui.questions.QuestionFactory;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({ "serial" })
public class GUIVisitor extends JFrame implements
	IQLFormNodeVisitor<Component>, IQLStatementNodeVisitor<Component> {

    Map<java.lang.String, List<java.lang.String>> dependentElements;
    List<Component> componentList = new ArrayList<Component>();

    EvaluatorVisitor evaluator;
    java.lang.String currentElement;

    public GUIVisitor(EvaluatorVisitor eval, DependentQuestionsVisitor d) {
	evaluator = eval;
	dependentElements = d.getDependentElements();
    }

    public EvaluatorVisitor getEvaluator() {
	return evaluator;
    }

    public List<Component> getComponentList() {
	return componentList;
    }

    public Component visit(Form questionnaire) throws RecognitionException {
	List<Statement> statements = questionnaire.getStatements();
	for (Statement statement : statements) {
	    statement.accept(this);
	}
	return null;
    }

    public JPanel visit(Question question) {
	QuestionFactory questionFactory = new QuestionFactory();
	uva.sc.ql.gui.questions.Question questionGUI = questionFactory.questionType(
		question, dependentElements, evaluator, componentList);

	currentElement = question.getId().getValue();
	boolean isEditable = evaluator.getValuesTable().get(currentElement)
		.getValue() == null;
	componentList.add(questionGUI.drawQuestion(currentElement,
		question.getStr(), isEditable));
	return null;
    }

    public JPanel visit(IfStatement ifStatement) {
	List<Question> questions = ifStatement.getQuestions();

	for (Question question : questions) {
	    question.accept(this);
	}
	return null;
    }

}