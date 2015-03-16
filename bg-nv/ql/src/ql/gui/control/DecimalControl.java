package ql.gui.control;

import ql.semantics.values.DecimalValue;
import ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface DecimalControl extends ControlType
{
    public void setValue(UndefinedValue value);
    public void setValue(DecimalValue value);
}
