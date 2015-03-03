package lang.qls.ast.Rule.Widget;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Radio extends WidgetRule
{
    private List<String> values;

    public Radio(List<String> values)
    {
        this.values = values;
    }

    public List<String> getValues()
    {
        return this.values;
    }
}
