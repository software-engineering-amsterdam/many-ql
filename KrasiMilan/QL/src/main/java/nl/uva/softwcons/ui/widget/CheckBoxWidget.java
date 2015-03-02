package nl.uva.softwcons.ui.widget;

import javafx.beans.property.Property;
import javafx.scene.control.CheckBox;
import nl.uva.softwcons.eval.value.Value;

public class CheckBoxWidget extends Widget {

    private CheckBox checkBox;

    public CheckBoxWidget(String checkString) {
        checkBox = new CheckBox(checkString);
    }

    @Override
    public CheckBox getWidget() {
        return checkBox;
    }

    @Override
    public void setValue(Value value) {
        if (value.asBoolean()) {
            checkBox.setSelected(true);
            return;
        }
    }

    @Override
    public void processValueChanged(Value oldValue, Value newValue) {
        setValue(newValue);
    }

}
