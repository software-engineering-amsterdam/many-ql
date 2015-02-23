package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class Neg extends UnaryExpr
{
    public Neg(Expr operand, int lineNumber)
    {
        super(operand, lineNumber);
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
