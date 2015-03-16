package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Node;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */

//TODO: Create ifsequence class.
public class IfStatement extends Node implements ContainsExpression {
    private Expression expression;

    public IfStatement(int lineNumber) {
        super(lineNumber, IfStatement.class);
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
        if (result instanceof BooleanResult) {
            for (Node child : this.getChildren()) {
                child.isVisible(((BooleanResult) result).getResult());
            }
        }
    }
}
