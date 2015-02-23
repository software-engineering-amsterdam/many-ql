package org.fugazi.evaluator;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.Expression;
import org.fugazi.evaluator.visitor.EvaluationExprVisitor;

public class Evaluator {

    private ValueStorage values;
    private final EvaluationExprVisitor expressionVisitor;
    
    public Evaluator(ValueStorage _values) {
        this.values = _values;
        this.expressionVisitor = new EvaluationExprVisitor(values);
    }

    public void saveValue(String _id, ExpressionValue _val) {
        this.values.put(_id, _val);
    }

    public ExpressionValue getValue(String _id) {
        return this.values.containsKey(_id) ? this.values.get(_id) : new UndefinedValue();
    }
    
    public Boolean isValueExists(String _id) {
        return this.values.containsKey(_id);
    }

    public ExpressionValue evaluateExpression(Expression _expression) {
        return _expression.accept(this.expressionVisitor);
    }
}
