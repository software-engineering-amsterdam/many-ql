package qls.ast.rule.widget;

import java.math.BigDecimal;

/**
 * Created by bore on 09/03/15.
 */
public abstract class NumWidgetValue<T> extends WidgetValue
{
    private final T min;
    private final T max;
    private final T step;

    public NumWidgetValue(T min, T max, T step)
    {
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public T getMin()
    {
        return this.min;
    }

    public T getMax()
    {
        return this.max;
    }

    public T getStep()
    {
        return this.step;
    }
}
