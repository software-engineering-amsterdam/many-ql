package lang.ql.gui.input.regular;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import lang.ql.gui.input.Input;
import lang.ql.semantics.ValueTable;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class RegularInput<T extends Control> extends Input<T>
{
    public RegularInput(String id, T control)
    {
        super(id, control);
    }

    public RegularInput(String id, T control, Boolean visible, Boolean disabled)
    {
        super(id, control, visible, disabled);
    }

    @Override
    public void update(ValueTable valueTable)
    {
        Control control = super.getControl();
        control.setDisable(getDisabled());
        control.setVisible(getVisible());
        setChanged();
        notifyObservers(valueTable);
    }
}
