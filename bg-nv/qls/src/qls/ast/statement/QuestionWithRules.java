package qls.ast.statement;

import qls.ast.rule.Rules;
import qls.ast.statement.*;

/**
 * Created by bore on 02/03/15.
 */
public class QuestionWithRules extends qls.ast.statement.Question
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
    public boolean isStyleDefinition()
    {
        return false;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
