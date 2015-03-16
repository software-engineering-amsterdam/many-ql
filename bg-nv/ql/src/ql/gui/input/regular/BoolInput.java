package ql.gui.input.regular;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import ql.gui.ModelVisitor;
import ql.gui.control.BooleanControl;
import ql.gui.control.Control;
import ql.semantics.ValueTable;
import ql.semantics.values.BoolValue;
import ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends RegularInput<Boolean>
{
    private final BooleanControl control;

    public BoolInput(String id, BooleanControl control)
    {
        this(id, control, true, false);
    }

    public BoolInput(String id, BooleanControl control, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);
        this.control = control;
        this.inputNode = this.createInputNode(control);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        super.setDisabled(disabled);
        this.control.setDisabled(disabled);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.control.setVisible(visible);
    }

    @Override
    protected VBox createInputNode(Control control)
    {
        VBox box = new VBox();
        box.getChildren().add(this.control.getGuiElement());
        box.getChildren().add(this.getErrorField());
        box.setAlignment(Pos.TOP_RIGHT);
        box.setVisible(this.getVisible());
        return box;
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Value convertUserInputToValue(Boolean userInput)
    {
        this.resetValidation();
        return new BoolValue(userInput);
    }

    @Override
    public void attachListener(ValueTable valueTable)
    {
        ChangeListener<Boolean> cl = this.constructChangeListener(valueTable);
        this.control.addListener(cl);
    }
}