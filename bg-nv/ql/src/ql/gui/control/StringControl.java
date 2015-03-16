package ql.gui.control;

import ql.semantics.values.StringValue;
import ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface StringControl extends ControlType
{
    public void setValue(UndefinedValue value);
    public void setValue(StringValue value);

}