package lang.qls.ast.Rule;

import lang.ql.ast.AstNode;

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

    public abstract <T> T accept(RuleVisitor<T> visitor);
}
