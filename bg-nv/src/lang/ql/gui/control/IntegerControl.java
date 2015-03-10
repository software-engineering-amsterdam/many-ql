package lang.ql.gui.control;

import javafx.beans.value.ChangeListener;
import lang.ql.semantics.values.IntegerValue;
import lang.ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public interface IntegerControl extends ControlType
{
    public void setValue(UndefinedValue value);
    public void setValue(IntegerValue value);
}
