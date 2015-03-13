package lang.qls.ast.statement;

import lang.ql.ast.type.Type;
import lang.qls.ast.rule.Rules;

/**
 * Created by bore on 02/03/15.
 */
public class DefaultStat extends Statement
{
    private final Type type;
    private final Rules body;

    public DefaultStat(Type type, Rules body, int lineNumber)
    {
        super(lineNumber);
        this.type = type;
        this.body = body;
    }

    public Type getType()
    {
        return this.type;
    }

    public Rules getBody()
    {
        return this.body;
    }

    @Override
    public boolean isStyleDefinition()
    {
        return true;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
