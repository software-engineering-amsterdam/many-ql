package lang.ql.gui.input.regular;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.VBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.control.Control;
import lang.ql.gui.control.ControlType;
import lang.ql.gui.control.DecimalControl;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.errors.Warning;
import lang.ql.semantics.values.DecimalValue;
import lang.ql.semantics.values.UndefinedValue;
import lang.ql.semantics.values.Value;

import java.math.BigDecimal;

/**
 * Created by Nik on 22-02-2015
 */
public class DecInput extends RegularInput<String>
{
    private final DecimalControl control;

    public DecInput(String id, DecimalControl control)
    {
        this(id, control, true, false);
    }

    public DecInput(String id, DecimalControl control, Boolean visible, Boolean disabled)
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
            BigDecimal decValue = new BigDecimal(userInput);
            value = new DecimalValue(decValue);
        }
        catch (NumberFormatException e)
        {
            value = new UndefinedValue();
            this.addValidationError(new Warning("The entered value is not a decimal number."));
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