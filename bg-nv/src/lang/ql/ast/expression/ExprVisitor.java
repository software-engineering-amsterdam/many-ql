package lang.ql.ast.expression;

/**
 * Created by bore on 24/02/15.
 */
public interface ExprVisitor<T>
{
    T visit(BoolExpr e);
    T visit(IntExpr e);
    T visit(DecExpr e);
    T visit(StrExpr e);
    T visit(Ident e);

    T visit(Neg e);
    T visit(Pos e);
    T visit(Not e);

    T visit(Add e);
    T visit(Sub e);
    T visit(Mul e);
    T visit(Div e);

    T visit(Gt e);
    T visit(Lt e);
    T visit(GtEqu e);
    T visit(LtEqu e);
    T visit(Equ e);
    T visit(NotEqu e);

    T visit(And e);
    T visit(Or e);
}
