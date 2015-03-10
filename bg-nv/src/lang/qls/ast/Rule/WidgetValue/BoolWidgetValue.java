package lang.qls.ast.Rule.WidgetValue;

/**
 * Created by bore on 09/03/15.
 */
public abstract class BoolWidgetValue extends WidgetValue
{
    private final String yesLabel;
    private final String noLabel;

    public BoolWidgetValue(String label, String yesLabel, String noLabel)
    {
        super(label);
        this.yesLabel = yesLabel;
        this.noLabel = noLabel;
    }

    public String getYesLabel()
    {
        return this.yesLabel;
    }

    public String getNoLabel()
    {
        return this.noLabel;
    }

}
