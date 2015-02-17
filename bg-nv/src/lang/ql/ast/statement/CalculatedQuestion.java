package lang.ql.ast.statement;

import lang.ql.ast.expression.Expression;
import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class CalculatedQuestion extends Question
{
    private Expression expression;

    public CalculatedQuestion(String id, QuestionType questionType, String text, Expression expression)
    {
        super(id, questionType, text);
        this.expression = expression;
    }

    public Expression getExpression()
    {
        return this.expression;
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
