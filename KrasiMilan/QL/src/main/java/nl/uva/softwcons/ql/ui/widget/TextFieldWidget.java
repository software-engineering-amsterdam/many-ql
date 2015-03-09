package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TextField;
import nl.uva.softwcons.ql.eval.value.Value;

public class TextFieldWidget extends Widget {
    private TextField textField;
    private Property<Value> valueProperty;

    public TextFieldWidget() {
        this.textField = new TextField();
        this.valueProperty = new SimpleObjectProperty<Value>();
    }

    @Override
    public TextField getWidget() {
        return textField;
    }

    @Override
    public void setValue(Value value) {
        this.valueProperty.setValue(value);
    }

    @Override
    public void setVisible(boolean visible) {
        this.textField.setVisible(visible);
    }

    @Override
    public Property<Value> getValueProperty() {
        return valueProperty;
    }

}
