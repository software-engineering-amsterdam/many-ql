package lang.ql.gui.input.regular;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.control.Control;
import lang.ql.gui.control.ControlType;
import lang.ql.gui.control.IntegerControl;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.errors.Warning;
import lang.ql.semantics.values.IntegerValue;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class IntInput extends RegularInput<String>
{
    public final IntegerControl control;

    public IntInput(String id, IntegerControl control)
    {
        this(id, control, true, false);
    }

    public IntInput(String id, IntegerControl control, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);
        this.control = control;
        this.inputNode = this.createInputNode(control);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Value convertUserInputToValue(String userInput)
    {
        this.resetValidation();
        userInput = userInput.trim();
        Value value;
        try
        {
            Integer intValue = Integer.parseInt(userInput);
            value = new IntegerValue(intValue);
        }
        catch (NumberFormatException e)
        {
            value = new UndefinedValue();
            this.addValidationError(new Warning("The entered value is not an integer number."));
        }

        return value;
    }

    @Override
    protected VBox createInputNode(ControlType control)
    {
        VBox box = new VBox();
        box.getChildren().add(this.control.getGuiElement());
        box.getChildren().add(this.getErrorField());
        box.setAlignment(Pos.TOP_RIGHT);
        box.setVisible(this.getVisible());
        return box;
    }

    @Override
    public void attachListener(ValueTable valueTable)
    {
        ChangeListener<String> cl = this.constructChangeListener(valueTable);
        this.control.addListener(cl);
    }
}