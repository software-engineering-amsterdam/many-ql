package lang.ql.gui.input.expression;

import lang.ql.ast.expression.Expr;
import lang.ql.gui.input.Input;

/**
 * Created by Nik on 28-02-2015
 */
public abstract class ExprInput extends Input
{
    private Expr expression;

    public ExprInput(String id, Expr expression)
    {
        super(id);
        this.expression = expression;
    }

    public ExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, visible, false);
        this.expression = expression;
    }
}
