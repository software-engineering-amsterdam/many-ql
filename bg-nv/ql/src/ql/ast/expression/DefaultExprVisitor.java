package ql.ast.expression;

/**
 * Created by bore on 16/03/15.
 */
public abstract class DefaultExprVisitor<T> implements ExprVisitor<T>
{
    public abstract T visitDefault(Expr e);

    public abstract T visitBinary(BinaryExpr e);

    public abstract T visitUnary(UnaryExpr e);

    @Override
    public T visit(BoolExpr e)
    {
        return this.visitDefault(e);
    }

    @Override
    public T visit(IntExpr e)
    {
        return this.visitDefault(e);
    }

    @Override
    public T visit(DecExpr e)
    {
        return this.visitDefault(e);
    }

    @Override
    public T visit(StrExpr e)
    {
        return this.visitDefault(e);
    }

    @Override
    public T visit(Ident e)
    {
        return this.visitDefault(e);
    }

    @Override
    public T visit(Neg e)
    {
        return this.visitUnary(e);
    }

    @Override
    public T visit(Pos e)
    {
        return this.visitUnary(e);
    }

    @Override
    public T visit(Not e)
    {
        return this.visitUnary(e);
    }

    @Override
    public T visit(Add e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Sub e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Mul e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Div e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Gt e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Lt e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(GtEqu e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(LtEqu e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Equ e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(NotEqu e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(And e)
    {
        return this.visitBinary(e);
    }

    @Override
    public T visit(Or e)
    {
        return this.visitBinary(e);
    }
}
