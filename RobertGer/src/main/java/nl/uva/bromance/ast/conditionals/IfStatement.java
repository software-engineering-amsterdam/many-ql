package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.QlNodeVisitor;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */

//TODO: Create ifsequence class.
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
                child.isVisible(((BooleanResult) result).getResult());
            }
        }
    }

    @Override
    public void accept(QlNodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }
}
