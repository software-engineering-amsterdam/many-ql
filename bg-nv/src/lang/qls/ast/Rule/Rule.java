package lang.qls.ast.Rule;

import lang.ql.ast.AstNode;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 02/03/15.
 */
public abstract class Rule<V> extends AstNode
{
    private String label;
    private V value;

    public Rule(String label, V value, int lineNumber)
    {
        super(lineNumber);
        this.label = label;
        this.value = value;
    }

    public String getLabel()
    {
        return this.label;
    }

    public V getValue()
    {
        return this.value;
    }

    public boolean isCompatibleWithType(Type t)
    {
        return true;
    }

    public boolean isOverwrittenBy(Rule r)
    {
        return false;
    }

    protected boolean isOverwrittenByWidth(Width r)
    {
        return false;
    }

    protected boolean isOverwrittenByWidget(Widget r)
    {
        return false;
    }

    protected boolean isOverwrittenByFont(Font r)
    {
        return false;
    }

    public abstract <T> T accept(RuleVisitor<T> visitor);
}
