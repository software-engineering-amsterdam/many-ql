package lang.qls.ast.Rule.WidgetValue;

/**
 * Created by bore on 09/03/15.
 */
public abstract class NumWidgetValue extends WidgetValue
{
    private final Integer min;
    private final Integer max;
    private final Integer step;

    public NumWidgetValue(String label, Integer min, Integer max, Integer step)
    {
        super(label);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public Integer getMin()
    {
        return this.min;
    }

    public Integer getMax()
    {
        return this.max;
    }

    public Integer getStep()
    {
        return this.step;
    }
}
