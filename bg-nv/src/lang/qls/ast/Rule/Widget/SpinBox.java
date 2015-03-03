package lang.qls.ast.Rule.Widget;

/**
 * Created by bore on 02/03/15.
 */
public class SpinBox extends WidgetRule
{
    private Integer min;
    private Integer max;

    public SpinBox()
    {

    }

    public SpinBox(Integer min, Integer max)
    {
        this.min = min;
        this.max = max;
    }
}
