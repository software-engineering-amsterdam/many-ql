package ql.gui.control;

import ql.semantics.values.DecValue;
import ql.semantics.values.UndefValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface DecimalControl extends ControlType
{
    public void setValue(UndefValue value);
    public void setValue(DecValue value);
}
