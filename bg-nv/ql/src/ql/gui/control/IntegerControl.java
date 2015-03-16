package ql.gui.control;

import ql.semantics.values.IntValue;
import ql.semantics.values.UndefValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface IntegerControl extends ControlType
{
    public void setValue(UndefValue value);
    public void setValue(IntValue value);
}
