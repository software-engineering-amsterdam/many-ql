package ql.gui.input;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ql.gui.control.Control;
import ql.semantics.ValueTableEntry;
import ql.semantics.errors.Message;
import ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class RegularInput<T> extends Input
{
    private final Text errorField;
    public RegularInput(String id, Control control, Boolean visible, Boolean disabled)
    {
        super(id, control, visible, disabled);

        this.control.addListener(this.constructChangeListener());

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

    private ChangeListener<T> constructChangeListener() {
        return (observable, oldValue, newValue) -> update(newValue);
    }

    private void update(T userInput)
    {
        Value val = this.convertUserInputToValue(userInput);
        this.setChanged();
        this.notifyObservers(new ValueTableEntry(this.getId(), val));
    }

    protected abstract Value convertUserInputToValue(T userInput);
}