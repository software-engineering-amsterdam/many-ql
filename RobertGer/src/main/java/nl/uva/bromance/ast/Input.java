package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.ContainsExpression;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.Result;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Input extends Node implements ContainsExpression {
    private Expression expression;

    public Input(int lineNumber) {
        super(lineNumber, Input.class);
    }

    @Override
    public Expression getExpression() {
        return expression;
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void handleExpressionResult(Result result) {

    }
}
