package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import ql.semantics.values.BoolValue;
import ql.semantics.values.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Nik on 16-3-15.
 */
public class Dropdown extends ControlElement implements BoolControl
{
    public final ComboBox<String> dropdown;
    private final String trueLabel;
    private final String falseLabel;
    private final VBox box;

    public Dropdown(String trueLabel, String falseLabel)
    {
        super();
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
        this.dropdown = new ComboBox<>();
        this.dropdown.getItems().add(this.trueLabel);
        this.dropdown.getItems().add(this.falseLabel);
        this.box = new VBox();
        this.box.getChildren().add(this.dropdown);
        this.box.setAlignment(Pos.BOTTOM_RIGHT);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.dropdown.setDisable(disabled);
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public Void visit(BoolValue val)
    {
        this.dropdown.setValue(val.getValue() ? this.trueLabel : this.falseLabel);
        return null;
    }

    @Override
    public Node getControlNode()
    {
        return this.box;
    }

    @Override
    public void addListener(ChangeListener listener)
    {
        // TODO: which property do I need here?
        this.dropdown.valueProperty().addListener(listener);
    }

    @Override
    public Value getBoolValue()
    {
        String selectedLabel = this.dropdown.getValue();
        Boolean val = selectedLabel.equals(this.trueLabel);
        return new BoolValue(val);
    }

    @Override
    public <T> T accept(ControlVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

}
