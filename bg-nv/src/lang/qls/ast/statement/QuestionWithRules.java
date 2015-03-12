package lang.qls.ast.statement;

import lang.qls.ast.rule.Rules;

/**
 * Created by bore on 02/03/15.
 */
public class QuestionWithRules extends Question
{
    private final Rules body;

    public QuestionWithRules(String id, int lineNumber, Rules body)
    {
        super(id, lineNumber);
        this.body = body;
    }

    public Rules getBody()
    {
        return this.body;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
