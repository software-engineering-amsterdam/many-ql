package lang.ql.ast.statement;

import lang.ql.ast.expression.Expr;
import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class CalculatedQuestion extends Question
{
    private Expr expr;

    public CalculatedQuestion(String id, QuestionType questionType, String text, Expr expr)
    {
        super(id, questionType, text);
        this.expr = expr;
    }

    public Expr getExpr()
    {
        return this.expr;
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
