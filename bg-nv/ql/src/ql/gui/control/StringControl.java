package ql.gui.control;

import ql.semantics.values.StrValue;
import ql.semantics.values.UndefValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface StringControl extends ControlType
{
    public void setValue(UndefValue value);
    public void setValue(StrValue value);

}