package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class Pos extends UnaryOperator
{
    public Pos(Expression operand)
    {
        super(operand);
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
