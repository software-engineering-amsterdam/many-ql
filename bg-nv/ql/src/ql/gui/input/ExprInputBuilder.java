package ql.gui.input;

import ql.ast.expression.Expr;
import ql.ast.type.*;
import ql.gui.control.CheckBox;
import ql.gui.control.TextField;
import ql.gui.input.expression.*;

/**
 * Created by Nik on 28-02-2015
 */
public class ExprInputBuilder implements TypeVisitor<ExprInput>
{
    private String id;
    private Expr expression;
    private final Boolean DISABLED = true;
    private final Boolean VISIBLE = true;

    public static ExprInput build(String id, Expr expression, Type type)
    {
        ExprInputBuilder b = new ExprInputBuilder(id, expression);
        return type.accept(b);
    }

    private ExprInputBuilder(String id, Expr expression)
    {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public ExprInput visit(BoolType type)
    {
        return new BoolExprInput(this.id, new CheckBox(VISIBLE, DISABLED), this.expression);
    }

    @Override
    public ExprInput visit(DateType type)
    {
        return new DateExprInput(this.id, this.expression);
    }

    @Override
    public ExprInput visit(DecType type)
    {
        return new DecExprInput(this.id, new TextField(VISIBLE, DISABLED), this.expression);
    }

    @Override
    public ExprInput visit(IntType type)
    {
        return new IntExprInput(this.id, new TextField(VISIBLE, DISABLED), this.expression);
    }

    @Override
    public ExprInput visit(StrType type)
    {
        return new StrExprInput(this.id, new TextField(VISIBLE, DISABLED), this.expression);
    }

    @Override
    public ExprInput visit(UndefType type)
    {
        return null;
    }
}
