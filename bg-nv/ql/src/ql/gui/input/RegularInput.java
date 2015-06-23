package ql.gui.input;

import javafx.beans.value.ChangeListener;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ql.gui.control.Control;
import ql.semantics.errors.Message;
import ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class RegularInput<T extends Control> extends Input<T>
{
    private final Text errorField;

    public RegularInput(String id, T control)
    {
        super(id, control, false);

        this.control.addListener(this.constructChangeListener());

        this.errorField = new Text(null);
        this.errorField.setFill(Color.FIREBRICK);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);
        this.fillInputNode();
    }

    @Override
    protected void fillInputNode()
    {
        super.fillInputNode();
        this.inputNode.getChildren().add(this.errorField);
    }

    @Override
    public void switchControl(T control)
    {
        super.switchControl(control);
        this.control.addListener(this.constructChangeListener());
    }

    protected void addValidationError(Message validationError)
    {
        this.errorField.setText(validationError.getMessage());
        this.errorField.setVisible(true);
        this.errorField.setManaged(true);
    }

    protected void resetValidation()
    {
        this.errorField.setText(null);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);
    }

    private ChangeListener<Object> constructChangeListener() {
        return (observable, oldValue, newValue) -> update();
    }

    private void update()
    {
        this.resetValidation();
        Value val = this.convertUserInputToValue();
        if (val.isUndefined())
        {
            this.addValidationError(this.getInvalidInputErrorMsg());
        }
        this.setChanged();
        this.notifyObservers(val);
    }

    protected abstract Value convertUserInputToValue();

    protected abstract Message getInvalidInputErrorMsg();
}