package ql.gui.control;

import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface BooleanControl extends ControlType
{
    public void setValue(UndefValue value);
    public void setValue(BoolValue value);
}
