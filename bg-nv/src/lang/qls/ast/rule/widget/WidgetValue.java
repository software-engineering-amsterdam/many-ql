package lang.qls.ast.rule.widget;

import lang.ql.ast.AstNode;
import lang.ql.ast.type.Type;
import lang.qls.ast.rule.RuleVisitor;

/**
 * Created by bore on 08/03/15.
 */
public abstract class WidgetValue extends AstNode
{
    private final String title;

    public WidgetValue(String title)
    {
        this.title = title;
    }

    public abstract boolean isCompatibleWithType(Type t);

    public abstract <T> T accept(WidgetVisitor<T> visitor);
}
