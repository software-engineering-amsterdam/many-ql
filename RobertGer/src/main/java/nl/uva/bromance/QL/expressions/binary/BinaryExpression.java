package nl.uva.bromance.QL.expressions.binary;

import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.expressions.Expression;

public abstract class BinaryExpression extends Expression {
    protected Expression lhs;
    protected Expression rhs;

    public BinaryExpression(Expression lhs, Expression rhs, int lineNumber){
        super(lineNumber);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        lhs.accept(visitor);
        rhs.accept(visitor);
    }
}
