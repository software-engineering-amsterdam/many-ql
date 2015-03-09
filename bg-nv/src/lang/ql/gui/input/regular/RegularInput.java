package lang.ql.gui.input.regular;

import javafx.scene.control.Control;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import lang.ql.gui.input.Input;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.errors.Message;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class RegularInput<T extends Control, U extends Object> extends Input<T>
{
    private Text errorField;

    public RegularInput(String id, T control, Boolean visible, Boolean disabled)
    {
        super(id, control, visible, disabled);
        this.errorField = new Text(null);
        this.errorField.setFill(Color.FIREBRICK);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);
    }

    public abstract Value convertUserInputToValue(U userInput);

    public void processUserInput(U userInput, ValueTable valueTable)
    {
        valueTable.storeValue(this.getId(), this.convertUserInputToValue(userInput));
        this.update(valueTable);
    }

    @Override
    public void update(ValueTable valueTable)
    {
        Control control = super.getControl();
        control.setDisable(getDisabled());
        control.setVisible(getVisible());
        setChanged();
        notifyObservers(valueTable);
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
}
