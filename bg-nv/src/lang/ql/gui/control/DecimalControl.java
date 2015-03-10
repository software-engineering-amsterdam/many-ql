package lang.ql.gui.control;

import lang.ql.semantics.values.DecimalValue;
import lang.ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface DecimalControl extends ControlType
{
    public void setValue(UndefinedValue value);
    public void setValue(DecimalValue value);
}
