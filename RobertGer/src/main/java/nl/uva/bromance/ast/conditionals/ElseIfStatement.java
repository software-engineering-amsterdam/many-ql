package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.QlNodeVisitor;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class ElseIfStatement extends QLNode implements ContainsExpression {
    private Expression expression;

    public ElseIfStatement(int lineNumber) {
        super(lineNumber);
    }


    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    //TODO: This is duplication. It is also present in IfStatement
    @Override
    public void handleExpressionResult() {
        Result result = expression.getResult();
        if (result instanceof BooleanResult) {
            for (QLNode child : this.getChildren()) {
                child.setVisible(((BooleanResult) result).getResult());
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
