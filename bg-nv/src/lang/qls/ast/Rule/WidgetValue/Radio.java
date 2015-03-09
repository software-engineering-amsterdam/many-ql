package lang.qls.ast.Rule.WidgetValue;

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
}
