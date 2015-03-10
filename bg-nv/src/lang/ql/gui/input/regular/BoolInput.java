package lang.ql.gui.input.regular;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.CheckBox;
import lang.ql.gui.ModelVisitor;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 22-02-2015
 */
public class BoolInput extends RegularInput<Boolean, CheckBox>
{
    public BoolInput(String id)
    {
        this(id, true, false);
    }

    public BoolInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, new CheckBox(), visible, disabled);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        super.setDisabled(disabled);
        this.control.setDisable(disabled);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.control.setVisible(visible);
        this.control.setManaged(visible);
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
        return new BooleanValue(userInput);
    }

    @Override
    public void attachListener(ValueTable valueTable)
    {
        ChangeListener<Boolean> cl = this.constructChangeListener(valueTable);
        this.control.selectedProperty().addListener(cl);
    }
}