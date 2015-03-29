package uva.sc.ql.evaluator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.ID;
import uva.sc.ql.expression.Expression;
import uva.sc.ql.form.Form;
import uva.sc.ql.gui.helpers.QuestionData;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({"rawtypes", "unchecked"})
public class QuestionsPropertiesVisitor extends Observable implements IQLStatementNodeVisitor, IQLFormNodeVisitor{

    Map<ID, QuestionData> valuesTable = new HashMap<ID, QuestionData>();
    Expression currentIfCondition;
    EvaluatorVisitor evalVisitor;
    
    public QuestionsPropertiesVisitor(EvaluatorVisitor evalVisitor) {
	this.evalVisitor = evalVisitor;
    }
    
    public QuestionData questionData (ID id) {
	return valuesTable.get(id);
    }
    
    public Map<ID, QuestionData> getValuesTable() {
	return valuesTable;
    }

    public void putToValuesTable(ID s, QuestionData d) {
	valuesTable.put(s, d);
	setChanged();
	notifyObservers();
    }

    public Expression visit(Form questionnaire) {
	List<Statement> statements = questionnaire.getStatements();
	for (Statement statement : statements) {
	    statement.accept(this);
	}
	return null;
    }

    public Expression visit(Question question) {
	if (question.getExpr() != null) {
	    putToValuesTable(question.getId(), new QuestionData(
		    question.getExpr(), currentIfCondition));
	} else {
	    putToValuesTable(question.getId(), new QuestionData(null,
		    currentIfCondition));
	}
	return null;
    }

    public Expression visit(IfStatement ifStatement) {
	currentIfCondition = ifStatement.getExpr();
	List<Question> questions = ifStatement.getQuestions();
	for (Question question : questions)
	    question.accept(this);
	currentIfCondition = null;
	return null;
    }
}
