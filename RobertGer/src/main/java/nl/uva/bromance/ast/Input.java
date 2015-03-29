package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.ContainsExpression;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Input extends QLNode implements ContainsExpression {
    private Expression expression;

    public Input(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void handleExpressionResult() {

    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }
}
