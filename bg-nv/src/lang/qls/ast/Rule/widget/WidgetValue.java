package lang.qls.ast.rule.widget;

import lang.ql.ast.AstNode;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public abstract class WidgetValue extends AstNode
{
    private String title;

    public WidgetValue(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }

    public abstract boolean isCompatibleWithType(Type t);
}
