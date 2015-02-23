package org.fugazi.evaluator;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.Expression;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.evaluator.visitor.EvaluationExprVisitor;

public class Evaluator {

    private ValueStorage values;
    private final EvaluationExprVisitor expressionVisitor;
    
    public Evaluator(ValueStorage _values) {
        this.values = _values;
        this.expressionVisitor = new EvaluationExprVisitor(values);
    }

    public ExpressionValue evaluateExpression(Expression _expression) {
        return _expression.accept(this.expressionVisitor);
    }
}
