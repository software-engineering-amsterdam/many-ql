package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Add extends BinaryOperator
{
    public Add(Expression left, Expression right)
    {
        super(left, right);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
