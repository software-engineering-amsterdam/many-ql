package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 17/02/15.
 */
public class Not extends UnaryExpr
{
    public Not(Expr operand, int lineNumber)
    {
        super(operand, lineNumber);
    }

    public <T> T accept(Visitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
