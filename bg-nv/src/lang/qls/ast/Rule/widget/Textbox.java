package lang.qls.ast.rule.widget;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Textbox extends WidgetValue
{
    public Textbox()
    {
        super("textbox");
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isNumerical() || t.isString();
    }


    @Override
    public <T> T accept(WidgetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
