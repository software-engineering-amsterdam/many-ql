package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import ql.gui.ModelVisitor;
import ql.semantics.values.BooleanValue;
import ql.semantics.values.UndefinedValue;

/**
 * Created by Nik on 10-3-15.
 */
//TODO: fix the groups
public class Radios extends Control implements BooleanControl
{
    private final Radio trueRadio;
    private final Radio falseRadio;

    public Radios(Boolean visible, Boolean disabled, String trueLabel, String falseLabel)
    {
        super(visible, disabled);
        this.trueRadio = new Radio(visible, disabled, true, trueLabel);
        this.falseRadio = new Radio(visible, disabled, false, falseLabel);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.falseRadio.setVisible(visible);
        this.trueRadio.setVisible(visible);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.trueRadio.setDisabled(disabled);
        this.falseRadio.setDisabled(disabled);
    }

    @Override
    public void setValue(UndefinedValue value)
    {
        this.trueRadio.setSelected(false);
        this.falseRadio.setSelected(false);
    }

    @Override
    public void setValue(BooleanValue value)
    {
        this.trueRadio.setSelected(value.getValue());
        this.falseRadio.setSelected(!value.getValue());
    }

    @Override
    public void addListener(ChangeListener listener)
    {
        //TODO
    }

    @Override
    public Node getGuiElement()
    {
        //TODO
        return new VBox();
    }
}
