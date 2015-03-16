package nl.uva.se.gui.validators;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.evaluation.ExpressionEvaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.BooleanValue;

public abstract class Validator<T> {
	
	//TODO: REMOVE THIS
	//public abstract boolean match(Question question, T oldValue, T newValue);	
	
	public abstract boolean isValid(T input);
	
	public boolean Evaluate(final Expression expression, final ValueTable values){
		BooleanValue something = (BooleanValue) ExpressionEvaluator.evaluate(expression, values);
		return something.getValue();		
	}
}
