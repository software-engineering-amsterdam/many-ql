package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ql.gui.ModelVisitor;
import ql.semantics.values.BoolValue;
import ql.semantics.values.UndefValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 10-3-15.
 */
public class Radio extends ControlElement implements BoolControl
{
    private final ToggleGroup group;
    private final RadioButton trueRadio;
    private final RadioButton falseRadio;
    private final HBox controlNode;

    public Radio(Boolean visible, Boolean disabled, String trueLabel, String falseLabel)
    {
        super(visible, disabled);
        this.group = new ToggleGroup();
        this.trueRadio = this.createRadio(trueLabel, group);
        this.falseRadio = this.createRadio(falseLabel, group);

        this.controlNode = new HBox();
        this.controlNode.getChildren().addAll(this.trueRadio, this.falseRadio);
        this.controlNode.setAlignment(Pos.BOTTOM_RIGHT);

        this.setVisible(visible);
        this.setDisabled(disabled);
    }

    private RadioButton createRadio(String label, ToggleGroup group) {
        RadioButton radio = new RadioButton();
        radio.setText(label);
        radio.setToggleGroup(group);
        return radio;
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
        this.controlNode.setVisible(visible);
        this.controlNode.setManaged(visible);
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.trueRadio.setDisable(disabled);
        this.falseRadio.setDisable(disabled);
    }

    @Override
    public Void visit(UndefValue value)
    {
        this.trueRadio.setSelected(false);
        this.falseRadio.setSelected(false);
        return null;
    }

    @Override
    public Void visit(BoolValue value)
    {
        //TODO: make sure this works - are the groups ok?
        if (value.getValue())
        {
            this.trueRadio.setSelected(true);
        }
        else
        {
            this.falseRadio.setSelected(true);
        }
        return null;
    }

    @Override
    public void addListener(ChangeListener listener)
    {
        //TODO: does this work?
        this.group.selectedToggleProperty().addListener(listener);
    }

    @Override
    public Node getControlNode()
    {
        return this.controlNode;
    }

    @Override
    public Value getBoolValue()
    {
        return new BoolValue(true);
    }

    @Override
    public <T> T accept(ControlVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
