package lang.ql.gui.input;

import lang.ql.gui.GuiVisitor;
import lang.ql.semantics.values.DateValue;

/**
 * Created by Nik on 22-02-2015
 */
public class DateInput extends Input
{
    public DateInput()
    {
        super();
    }

    public DateInput(Boolean disabled)
    {
        super(disabled);
    }

    public void accept(GuiVisitor visitor)
    {
        visitor.visit(this);
    }
}
