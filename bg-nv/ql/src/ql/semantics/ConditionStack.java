package ql.semantics;

import ql.ast.expression.And;
import ql.ast.expression.BoolExpr;
import ql.ast.expression.Expr;

import java.util.Stack;

/**
 * Created by bore on 15/03/15.
 */
public class ConditionStack
{
    private final static BoolExpr trueBoolExpr = new BoolExpr(true);
    private final Stack<Expr> conditions;

    public ConditionStack()
    {
        this.conditions = new Stack<>();
    }

    public void push(Expr e)
    {
        Expr cond = e;
        if (!(this.conditions.isEmpty()))
        {
            Expr pr = this.conditions.peek();
            cond = new And(pr, e);
        }

        this.conditions.push(cond);
    }

    public void pop()
    {
        this.conditions.pop();
    }

    public Expr peek()
    {
        if (this.conditions.isEmpty())
        {
            return trueBoolExpr;
        }

        return this.conditions.peek();
    }
}
