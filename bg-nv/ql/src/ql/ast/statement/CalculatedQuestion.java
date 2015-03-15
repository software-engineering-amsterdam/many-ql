package ql.ast.statement;

import ql.ast.expression.Expr;
import ql.ast.type.Type;

/**
 * Created by bore on 14/02/15.
 */
public class CalculatedQuestion extends Question
{
    private final Expr calculation;

    public CalculatedQuestion(String id, Type type, String text, int lineNumber, Expr expr)
    {
        super(id, type, text, lineNumber);
        this.calculation = expr;
    }

    public Expr getCalculation()
    {
        return this.calculation;
    }

    @Override
    public <T> T accept(StatVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
