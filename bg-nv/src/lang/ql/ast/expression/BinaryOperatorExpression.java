package lang.ql.ast.expression;

import lang.ql.ast.AstNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryOperatorExpression extends Expression
{
    private Expression left;
    private Expression right;

    public BinaryOperatorExpression(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft()
    {
        return this.left;
    }

    public Expression getRight() { return this.right; }

    public Iterable<? extends AstNode> getChildren()
    {
        return Arrays.asList(this.left, this.right);
    }
}
