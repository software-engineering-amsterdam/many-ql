package ql.semantics;

import ql.ast.expression.*;
import ql.semantics.values.*;

/**
 * Created by bore on 23/02/15.
 */
public class ExprEvaluator implements ExprVisitor<Value>
{
    private final ValueTable valueTable;

    public static Value evaluate(Expr e, ValueTable valueTable)
    {
        ExprEvaluator eval = new ExprEvaluator(valueTable);
        return e.accept(eval);
    }

    private ExprEvaluator(ValueTable valueTable)
    {
        this.valueTable = valueTable;
    }

    @Override
    public Value visit(BoolExpr e)
    {
        return new BoolValue(e.getValue());
    }

    @Override
    public Value visit(IntExpr e)
    {
        return new IntValue(e.getValue());
    }

    @Override
    public Value visit(DecExpr e)
    {
        return new DecValue(e.getValue());
    }

    @Override
    public Value visit(StrExpr e)
    {
        return new StrValue(e.getValue());
    }

    @Override
    public Value visit(Ident id)
    {
        return this.valueTable.getValue(id.getId());
    }

    @Override
    public Value visit(Neg e)
    {
        Value op = e.getOperand().accept(this);
        return op.neg();
    }

    @Override
    public Value visit(Pos e)
    {
        Value op = e.getOperand().accept(this);
        return op.pos();
    }

    @Override
    public Value visit(Not e)
    {
        Value op = e.getOperand().accept(this);
        return op.not();
    }

    @Override
    public Value visit(Add e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.add(rightProm);
    }

    @Override
    public Value visit(Sub e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.sub(rightProm);
    }

    @Override
    public Value visit(Mul e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.mul(rightProm);
    }

    @Override
    public Value visit(Div e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.div(rightProm);
    }

    @Override
    public Value visit(Gt e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.gt(rightProm);
    }

    @Override
    public Value visit(Lt e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.lt(rightProm);
    }

    @Override
    public Value visit(GtEqu e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.gtEqu(rightProm);
    }

    @Override
    public Value visit(LtEqu e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.ltEqu(rightProm);
    }

    @Override
    public Value visit(Equ e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.equ(rightProm);
    }

    @Override
    public Value visit(NotEqu e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.notEqu(rightProm);
    }

    @Override
    public Value visit(And e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.and(rightProm);
    }

    @Override
    public Value visit(Or e)
    {
        Value left = e.getLeft().accept(this);
        Value right = e.getRight().accept(this);
        Value leftProm = left.promoteTo(right);
        Value rightProm = right.promoteTo(left);
        return leftProm.or(rightProm);
    }
}
