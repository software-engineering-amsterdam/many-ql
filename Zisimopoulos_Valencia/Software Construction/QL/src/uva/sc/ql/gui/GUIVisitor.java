package uva.sc.ql.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.ID;

import org.antlr.v4.runtime.RecognitionException;

import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.form.Form;
import uva.sc.ql.gui.questions.QuestionFactory;
import uva.sc.ql.patronElements.PatronQuestionsVisitor;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({ "serial" })
public class GUIVisitor extends JFrame implements
	IQLFormNodeVisitor<Component>, IQLStatementNodeVisitor<Component> {

    Map<ID, List<ID>> patronElements;
    List<Component> componentList = new ArrayList<Component>();

    EvaluatorVisitor evaluator;
    ID currentElement;

    public GUIVisitor(EvaluatorVisitor eval, PatronQuestionsVisitor d) {
	evaluator = eval;
	patronElements = d.getPatronElements();
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
		question, patronElements, evaluator, componentList);

	currentElement = question.getId();
	
	boolean isEditable = false;
	if (evaluator.getValuesTable().get(currentElement) != null)
	{
	    isEditable = evaluator.getValuesTable().get(currentElement).getValue() == null;
	}
	componentList.add(questionGUI.drawQuestion(currentElement, question.getStr(), isEditable));
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