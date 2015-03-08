package lang.qls.ast.Rule.WidgetValue;

/**
 * Created by bore on 08/03/15.
 */
public class Slider extends WidgetValue
{
    private Integer min;
    private Integer max;

    public Slider()
    {
        super("slider");
    }

    public Slider(Integer min, Integer max)
    {
        this();
        this.min = min;
        this.max = max;
    }
}
