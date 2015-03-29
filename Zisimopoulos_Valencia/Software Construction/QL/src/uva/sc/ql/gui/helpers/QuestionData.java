package uva.sc.ql.gui.helpers;

import java.util.Map;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
public class QuestionData {
    Expression value;
    Expression visibility;

    public Expression getValue() {
	return value;
    }

    public Expression getVisibility() {
	return visibility;
    }
    
    public QuestionData(Expression value) {
	this.value = value;
    }

    public QuestionData(Expression value, Expression visibility) {
	this.value = value;
	this.visibility = visibility;
    }
    
    public boolean evaluateVisibility(Map<ID, QuestionData> valuesTable) {
	BooleanAtom result = new BooleanAtom(true);
	if (visibility != null) {
	    EvaluatorVisitor evalVisitor = new EvaluatorVisitor(valuesTable);
	    result = (BooleanAtom) evalVisitor.evaluateExpression(visibility);
	}
	return result.getValue();
    }
    
    public Expression evaluateValue(Map<ID, QuestionData> valuesTable) {
	EvaluatorVisitor evalVisitor = new EvaluatorVisitor(valuesTable);
	Expression result = null;
	if (value != null) {
	    result = evalVisitor.evaluateExpression(value);
	}
	return result;
    }
    
}
