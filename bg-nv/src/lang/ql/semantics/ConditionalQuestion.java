package lang.ql.semantics;

import lang.ql.ast.expression.Expr;
import lang.ql.ast.statement.Question;

/**
 * Created by Nik on 10-3-15.
 */
public class ConditionalQuestion
{
    private Expr condition;
    private Question question;

    public ConditionalQuestion(Expr condition, Question question)
    {
        this.condition = condition;
        this.question = question;
    }

    public Expr getCondition()
    {
        return this.condition;
    }

    public Question getQuestion()
    {
        return this.question;
    }
}
