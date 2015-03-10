package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TextField;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.conveter.ValueConverter;

public class TextFieldWidget extends Widget {
    private TextField textField;
    private Property<Value> valueProperty;

    public TextFieldWidget(final ValueConverter<String> converter) {
        this.textField = new TextField();
        this.valueProperty = new SimpleObjectProperty<Value>();

        this.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            valueProperty.setValue(converter.toValue(newValue));
        });
    }

    @Override
    public TextField getWidget() {
        return textField;
    }

    @Override
    public void setValue(final Value value) {
        this.textField.setText(value.toString());
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
