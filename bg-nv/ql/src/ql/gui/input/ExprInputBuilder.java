package ql.gui.input;

import ql.ast.expression.Expr;
import ql.ast.type.*;
import ql.gui.control.CheckBox;
import ql.gui.control.TextField;

/**
 * Created by Nik on 28-02-2015
 */
public class ExprInputBuilder implements TypeVisitor<ExprInput>
{
    private final String id;
    private final Expr expression;

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
        return new ExprInput(this.id, new CheckBox(), this.expression);
    }

    @Override
    public ExprInput visit(DecType type)
    {
        return new ExprInput(this.id, new TextField(), this.expression);
    }

    @Override
    public ExprInput visit(IntType type)
    {
        return new ExprInput(this.id, new TextField(), this.expression);
    }

    @Override
    public ExprInput visit(StrType type)
    {
        return new ExprInput(this.id, new TextField(), this.expression);
    }

    @Override
    public ExprInput visit(UndefType type)
    {
        throw new IllegalArgumentException("Cannot build input for undefined type.");
    }
}
