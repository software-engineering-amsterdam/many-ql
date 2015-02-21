package lang.ql.ast.statement;

import lang.ql.ast.expression.Expr;
import lang.ql.ast.types.Type;
import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class CalculatedQuestion extends Question
{
    private Expr expr;

    public CalculatedQuestion(String id, Type type, String text, int lineNumber, Expr expr)
    {
        super(id, type, text, lineNumber);
        this.expr = expr;
    }

    public Expr getExpr()
    {
        return this.expr;
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
