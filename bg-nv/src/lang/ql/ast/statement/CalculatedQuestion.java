package lang.ql.ast.statement;

import lang.ql.ast.expression.Expr;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 14/02/15.
 */
public class CalculatedQuestion extends Question
{
    private Expr defaultValue;

    public CalculatedQuestion(String id, Type type, String text, int lineNumber, Expr expr)
    {
        super(id, type, text, lineNumber);
        this.defaultValue = expr;
    }

    public Expr getDefaultValue()
    {
        return this.defaultValue;
    }

    public <T> T accept(StatVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
