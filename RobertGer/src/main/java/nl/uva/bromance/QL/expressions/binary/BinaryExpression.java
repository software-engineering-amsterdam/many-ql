package nl.uva.bromance.QL.expressions.binary;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;

public abstract class BinaryExpression extends Expression {
    protected Expression lhs;
    protected Expression rhs;

    public BinaryExpression(Expression lhs, Expression rhs, int lineNumber){
        super(lineNumber);
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
