package ql.semantics;

import ql.ast.expression.Expr;
import ql.ast.statement.Question;

/**
 * Created by Nik on 10-3-15.
 */
public class ConditionalQuestion
{
    // TODO: this class is a code smell
    private final Expr condition;
    private final Question question;

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
