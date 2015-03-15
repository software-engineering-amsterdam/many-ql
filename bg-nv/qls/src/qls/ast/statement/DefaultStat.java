package qls.ast.statement;

import ql.ast.type.Type;
import qls.ast.rule.Rules;
import qls.ast.statement.*;

/**
 * Created by bore on 02/03/15.
 */
public class DefaultStat extends qls.ast.statement.Statement
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
    public boolean isRenderable()
    {
        return false;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
