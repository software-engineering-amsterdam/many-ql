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
public abstract class RegularInput<T extends Control> extends Input<T>
{
    private final Text errorField;

    public RegularInput(String id, T control)
    {
        super(id, control, true, false);

        this.control.addListener(this.constructChangeListener());

        this.errorField = new Text(null);
        this.errorField.setFill(Color.FIREBRICK);
        this.errorField.setVisible(false);
        this.errorField.setManaged(false);
        //this.control.setDisabled(true);
        this.inputNode = this.createInputNode(this.control);
    }
//
//    @Override
//    public void setDisabled(Boolean disabled)
//    {
//        super.setDisabled(disabled);
//        this.control.setDisabled(disabled);
//    }

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
        this.notifyObservers(new ValueTableEntry(this.getId(), val));
    }

    protected abstract Value convertUserInputToValue();
    protected abstract Message getInvalidInputErrorMsg();
}