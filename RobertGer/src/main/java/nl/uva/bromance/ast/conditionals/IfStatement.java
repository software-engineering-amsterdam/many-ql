package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;

public class IfStatement extends QLNode implements ContainsExpression {
    private Expression expression;

    public IfStatement(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void handleExpressionResult() {
        Result result = expression.getResult();
        //TODO: Should force this in TypeChecking.
        if (result instanceof BooleanResult) {
            for (QLNode child : this.getChildren()) {
                child.setVisible(((BooleanResult) result).getResult());
            }
        }
    }

    public boolean ExpressionEvaluatesToTrue() {
        Result result = expression.getResult();
        if (result instanceof BooleanResult) {
            return ((BooleanResult) result).getResult();
        }
        return false;
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
