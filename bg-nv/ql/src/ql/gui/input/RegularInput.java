package ql.gui.input;

import javafx.beans.value.ChangeListener;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ql.gui.input.Input;
import ql.semantics.ValueTable;
import ql.semantics.errors.Message;
import ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class RegularInput<T> extends Input
{
    private Text errorField;

    public RegularInput(String id, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);

        this.errorField = new Text(null);
        this.errorField.setFill(Color.FIREBRICK);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);
    }

    public abstract Value convertUserInputToValue(T userInput);

    public void update(ValueTable valueTable)
    {
        setChanged();
        notifyObservers(valueTable);
    }

    public void processUserInput(T userInput, ValueTable valueTable)
    {
        valueTable.storeValue(this.getId(), this.convertUserInputToValue(userInput));
        this.update(valueTable);
    }

    protected void resetValidation()
    {
        this.errorField.setText(null);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);
    }

    protected void addValidationError(Message validationError)
    {
        this.errorField.setText(validationError.getMessage());
        this.errorField.setVisible(true);
        this.errorField.setManaged(true);
    }

    public Text getErrorField()
    {
        return this.errorField;
    }
    
    public abstract void attachListener(ValueTable valueTable);

    protected ChangeListener<T> constructChangeListener(ValueTable valueTable)
    {
        return (observable, oldValue, newValue) -> processUserInput(newValue, valueTable);
    }
}