package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class Gt extends BinaryOperator
{
    public Gt(Expression left, Expression right)
    {
        super(left, right);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
