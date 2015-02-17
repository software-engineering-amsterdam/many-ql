package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

import java.math.BigInteger;

/**
 * Created by bore on 10/02/15.
 */
public class DecExpr extends ConstExpr<BigInteger>
{
    public DecExpr(BigInteger value)
    {
        super(value);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
