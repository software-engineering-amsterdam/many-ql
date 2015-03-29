package uva.sc.ql.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.runtime.RecognitionException;

import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.QuestionsPropertiesVisitor;
import uva.sc.ql.form.Form;
import uva.sc.ql.gui.helpers.QuestionData;
import uva.sc.ql.gui.questions.QuestionFactory;
import uva.sc.ql.patronElements.PatronQuestionsVisitor;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({ "serial" })
public class GUIVisitor extends JFrame implements
	IQLFormNodeVisitor<Component>, IQLStatementNodeVisitor<Component> {

    private Map<ID, List<ID>> patronElements;
    private List<Component> componentList = new ArrayList<Component>();
    private QuestionsPropertiesVisitor questionProperties;
    private ID currentElement;

    public GUIVisitor(QuestionsPropertiesVisitor questionsProperties,
	    PatronQuestionsVisitor patronQuesionVisitor) {
	this.patronElements = patronQuesionVisitor.getPatronElements();
	this.questionProperties = questionsProperties;
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
	currentElement = question.getId();
	boolean isEditable = false;
	QuestionData data = questionProperties.questionData(currentElement);
	QuestionFactory questionFactory = new QuestionFactory();
	uva.sc.ql.gui.questions.Question questionGUI = questionFactory
		.questionType(question, questionProperties, patronElements,
			componentList);
	if (data != null) {
	    isEditable = data
		    .evaluateValue(questionProperties.getValuesTable()) == null;
	}
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