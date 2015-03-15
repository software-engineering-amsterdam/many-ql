package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Node;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class ElseIfStatement extends Node implements ContainsExpression {
    private Expression expression;

    public ElseIfStatement(int lineNumber) {
        super(lineNumber, ElseIfStatement.class);
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
