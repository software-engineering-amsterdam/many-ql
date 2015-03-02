package lang.ql.gui.input;

import lang.ql.ast.expression.Expr;
import lang.ql.ast.type.*;
import lang.ql.gui.input.expression.*;

/**
 * Created by Nik on 28-02-2015
 */
public class ExprInputBuilder implements TypeVisitor<ExprInput>
{
    private String id;
    private Expr expression;

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
        return new BoolExprInput(this.id, this.expression);
    }

    @Override
    public ExprInput visit(DateType type)
    {
        return new DateExprInput(this.id, this.expression);
    }

    @Override
    public ExprInput visit(DecType type)
    {
        return new DecExprInput(this.id, this.expression);
    }

    @Override
    public ExprInput visit(IntType type)
    {
        return new IntExprInput(this.id, this.expression);
    }

    @Override
    public ExprInput visit(StrType type)
    {
        return new StrExprInput(this.id, this.expression);
    }

    @Override
    public ExprInput visit(UndefinedType type)
    {
        return null;
    }
}
