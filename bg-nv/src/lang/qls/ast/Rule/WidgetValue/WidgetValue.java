package lang.qls.ast.Rule.WidgetValue;

import lang.ql.ast.AstNode;

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
}
