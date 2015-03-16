package qls.ast.rule;

import ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public abstract class StrRule  extends Rule
{
    private String value;

    public StrRule(String value, int lineNumber)
    {
        super(lineNumber);
        this.value = value;
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return true;
    }

    public String getValue()
    {
        return this.value;
    }
}
