package ql.gui.input;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ql.gui.control.Control;
import ql.semantics.ValueTable;
import ql.semantics.errors.Message;
import ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class RegularInput<T> extends Input
{
    private final Text errorField;
    private final Control control;

    public RegularInput(String id, Control control, Boolean visible, Boolean disabled)
    {
        super(id, visible, disabled);

        this.control = control;

        this.errorField = new Text(null);
        this.errorField.setFill(Color.FIREBRICK);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);

        this.inputNode = this.createInputNode(this.control);
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
        box.getChildren().add(this.control.getControlNode());
        box.getChildren().add(this.errorField);
        box.setAlignment(Pos.TOP_RIGHT);
        box.setVisible(this.getVisible());
        return box;
    }

    public abstract Value convertUserInputToValue(T userInput);

    public void update(ValueTable valueTable)
    {
        setChanged();
        notifyObservers(valueTable);
    }

    public void processUserInput(T userInput, ValueTable valueTable)
    {
        Value val = this.convertUserInputToValue(userInput);
        valueTable.storeValue(this.getId(), val);
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

    public void attachListener(ValueTable valueTable)
    {
        ChangeListener<T> cl = this.constructChangeListener(valueTable);
        this.control.addListener(cl);
    }

    protected ChangeListener<T> constructChangeListener(ValueTable valueTable)
    {
        return (observable, oldValue, newValue) -> this.processUserInput(newValue, valueTable);
    }
}