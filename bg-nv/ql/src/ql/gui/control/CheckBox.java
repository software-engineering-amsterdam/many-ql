package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.gui.ModelVisitor;
import ql.semantics.values.BooleanValue;
import ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
public class CheckBox extends Control implements BooleanControl
{
    javafx.scene.control.CheckBox checkBox;

    public CheckBox(Boolean visible, Boolean disabled)
    {
        super(visible, disabled);
        this.checkBox = new javafx.scene.control.CheckBox();
        this.setVisible(visible);
        this.setDisabled(disabled);
    }

    @Override
    public Node getGuiElement()
    {
        return this.checkBox;
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.checkBox.setDisable(disabled);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        this.checkBox.setVisible(visible);
        this.checkBox.setManaged(visible);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void setValue(UndefinedValue value)
    {
        this.setSelected(false);
    }

    @Override
    public void setValue(BooleanValue value)
    {
        this.setSelected(value.getValue());
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
}