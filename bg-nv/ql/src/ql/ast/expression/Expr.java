package ql.ast.expression;

import ql.ast.AstNode;

/**
 * Created by bore on 09/02/15.
 */
public abstract class Expr extends AstNode
{
    public Expr(int lineNumber)
    {
        super(lineNumber);
    }

    public abstract <T> T accept(ExprVisitor<T> visitor);
}
