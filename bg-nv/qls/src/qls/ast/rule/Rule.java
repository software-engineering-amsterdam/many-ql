package qls.ast.rule;

import ql.ast.AstNode;
import ql.ast.type.Type;

/**
 * Created by bore on 02/03/15.
 */
public abstract class Rule extends AstNode
{
    public Rule(int lineNumber)
    {
        super(lineNumber);
    }

    public abstract boolean isCompatibleWithType(Type t);

    public boolean isOverwrittenBy(Rule r)
    {
        return false;
    }

    public boolean isRuleOverwrittenBy(Rules highPr)
    {
        for (Rule h : highPr)
        {
            if (this.isOverwrittenBy(h))
            {
                return true;
            }
        }

        return false;
    }

    protected boolean isOverwrittenByWidth(Width r)
    {
        return false;
    }

    protected boolean isOverwrittenByFont(Font r)
    {
        return false;
    }

    protected boolean isOverwrittenByFontSize(FontSize r)
    {
        return false;
    }

    protected boolean isOverwrittenByForeColor(ForeColor r)
    {
        return false;
    }

    protected boolean isOverwrittenByBackColor(BackColor r)
    {
        return false;
    }

    protected boolean isOverwrittenByWidget(Widget r)
    {
        return false;
    }

    public abstract <T> T accept(RuleVisitor<T> visitor);
}
