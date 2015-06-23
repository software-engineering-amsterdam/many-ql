package nl.uva.bromance.QL.expressions.binary;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.Expression;

/**
 * Created by Robert on 31-5-2015.
 */
public abstract class BinaryExpression implements Expression {
    protected Evaluable lhs;
    protected Evaluable rhs;

    public BinaryExpression(Evaluable lhs, Evaluable rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
