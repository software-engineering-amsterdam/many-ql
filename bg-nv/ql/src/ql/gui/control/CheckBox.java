package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 10-3-15.
 */
public class CheckBox extends ControlElement implements BoolControl
{
    private javafx.scene.control.CheckBox checkBox;

    public CheckBox()
    {
        this.checkBox = new javafx.scene.control.CheckBox();
    }

    @Override
    public Node getControlNode()
    {
        return this.checkBox;
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.checkBox.setDisable(disabled);
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public Void visit(BoolValue val)
    {
        this.setSelected(val.getValue());
        return null;
    }

    @Override
    public Void visit(UndefValue val)
    {
        this.setSelected(false);
        return null;
    }

    @Override
    public void addListener(ChangeListener listener)
    {
        this.checkBox.selectedProperty().addListener(listener);
    }

    private void setSelected(Boolean selected)
    {
        this.checkBox.setSelected(selected);
    }

    @Override
    public Value getBoolValue()
    {
        return new BoolValue(this.checkBox.isSelected());
    }
}