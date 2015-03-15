package ql.gui.control;

import ql.semantics.values.BooleanValue;
import ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface BooleanControl extends ControlType
{
    public void setValue(UndefinedValue value);
    public void setValue(BooleanValue value);
}
