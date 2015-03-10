package nl.uva.softwcons.ql.ui.widget;

import javafx.scene.control.TextField;
import nl.uva.softwcons.ql.eval.value.Value;

public class TextFieldWidget extends Widget {

    private TextField textField;

    public TextFieldWidget(final Value v) {
        textField = new TextField();
    }

    public TextFieldWidget(String defaultText) {
        textField = new TextField(defaultText);
    }

    @Override
    public TextField getWidget() {
        return textField;
    }

    @Override
    public void setValue(Value value) {
        textField.setText(value.asString());
    }

    @Override
    public void processValueChanged(Value oldValue, Value newValue) {
        setValue(newValue);
    }

}
