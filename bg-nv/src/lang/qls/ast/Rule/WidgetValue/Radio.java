package lang.qls.ast.Rule.WidgetValue;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Radio extends WidgetValue
{
    private String yesLabel;
    private String noLabel;

    public Radio(String yesLabel, String noLabel)
    {
        super("radio");
        this.yesLabel = yesLabel;
        this.noLabel = noLabel;
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isBool();
    }
}
