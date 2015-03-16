package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.gui.ModelVisitor;
import ql.semantics.values.*;

/**
 * Created by Nik on 10-3-15.
 */
public class TextField extends ControlElement implements BooleanControl, IntegerControl, DecimalControl, StringControl
{
    private final javafx.scene.control.TextInputControl textField;

    public TextField(Boolean visible, Boolean disabled)
    {
        super(visible, disabled);
        this.textField = new javafx.scene.control.TextField();
        this.setVisible(visible);
        this.setDisabled(disabled);
    }

    @Override
    public void setVisible(Boolean visible)
    {
        this.textField.setVisible(visible);
        this.textField.setManaged(visible);
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.textField.setDisable(disabled);
    }

    @Override
    public Node getGuiElement()
    {
        return this.textField;
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }


    @Override
    public void addListener(ChangeListener listener)
    {
        this.textField.textProperty().addListener(listener);
    }

    private void setText(String text)
    {
        this.textField.setText(text);
    }

    @Override
    public Void visit(DecimalValue val)
    {
        this.setText(val.getValue().toString());
        return null;
    }

    @Override
    public Void visit(IntegerValue val)
    {
        this.setText(val.getValue().toString());
        return null;
    }

    @Override
    public Void visit(StringValue val)
    {
        this.setText(val.getValue());
        return null;
    }

    @Override
    public Void visit(UndefinedValue val)
    {
        this.setText("");
        return null;
    }
}