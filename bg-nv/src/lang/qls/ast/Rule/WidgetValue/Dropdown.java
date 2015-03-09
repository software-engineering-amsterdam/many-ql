package lang.qls.ast.Rule.WidgetValue;

/**
 * Created by bore on 08/03/15.
 */
public class Dropdown extends WidgetValue
{
    private String yesLabel;
    private String noLabel;

    public Dropdown(String yesLabel, String noLabel)
    {
        super("dropdown");
        this.yesLabel = yesLabel;
        this.noLabel = noLabel;
    }
}
