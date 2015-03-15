package ql.gui.control;

import ql.semantics.values.IntegerValue;
import ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface IntegerControl extends ControlType
{
    public void setValue(UndefinedValue value);
    public void setValue(IntegerValue value);
}
