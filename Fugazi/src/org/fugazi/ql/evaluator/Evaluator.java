package org.fugazi.ql.evaluator;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.visitor.EvaluationExprVisitor;

public class Evaluator {
    
    private final EvaluationExprVisitor expressionVisitor;
    
    public Evaluator(ValueStorage _values) {
        this.expressionVisitor = new EvaluationExprVisitor(_values);
    }

    public ExpressionValue evaluateExpression(Expression _expression) {
        return _expression.accept(this.expressionVisitor);
    }
}
