package qls.ast.rule.widget;

import java.math.BigDecimal;

/**
 * Created by bore on 09/03/15.
 */
public abstract class NumWidgetValue extends WidgetValue
{
    private final BigDecimal min;
    private final BigDecimal max;
    private final BigDecimal step;

    public NumWidgetValue(String label, BigDecimal min, BigDecimal max, BigDecimal step)
    {
        super(label);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public BigDecimal getMin()
    {
        return this.min;
    }

    public BigDecimal getMax()
    {
        return this.max;
    }

    public BigDecimal getStep()
    {
        return this.step;
    }
}
