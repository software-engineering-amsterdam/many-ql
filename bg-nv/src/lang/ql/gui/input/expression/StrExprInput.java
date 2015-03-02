package lang.ql.gui.input.expression;

import lang.ql.ast.expression.Expr;
import lang.ql.gui.GuiModelVisitor;

/**
 * Created by Nik on 28-02-2015
 */
public class StrExprInput extends ExprInput
{
    public StrExprInput(String id, Expr expression)
    {
        super(id, expression);
    }

    public StrExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
    }

    @Override
    public <T> T accept(GuiModelVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}