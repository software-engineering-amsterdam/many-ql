package lang.qls.ast.rule;

import lang.ql.ast.AstNode;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 02/03/15.
 */
public abstract class Rule extends AstNode
{
    public Rule(int lineNumber)
    {
        super(lineNumber);
    }

    public boolean isCompatibleWithType(Type t)
    {
        throw new IllegalStateException("Unsupported rule type");
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
