package lang.ql.gui.input.expression;

import lang.ql.ast.expression.Expr;
import lang.ql.gui.ModelVisitor;

/**
 * Created by Nik on 28-02-2015
 */
public class IntExprInput extends ExprInput
{
    public IntExprInput(String id, Expr expression)
    {
        super(id, expression);
    }

    public IntExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
    }

    @Override
    public <T> T accept(ModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
