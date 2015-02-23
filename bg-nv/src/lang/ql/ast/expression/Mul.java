package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 17/02/15.
 */
public class Mul extends BinaryExpr
{
    public Mul(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}