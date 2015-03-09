package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.CheckBox;
import nl.uva.softwcons.ql.eval.value.Value;

public class CheckBoxWidget extends Widget {
    private CheckBox checkBox;
    private Property<Value> valueProperty;

    public CheckBoxWidget(final String checkString) {
        this.checkBox = new CheckBox(checkString);
        this.valueProperty = new SimpleObjectProperty<Value>();
    }

    @Override
    public CheckBox getWidget() {
        return checkBox;
    }

    @Override
    public void setValue(Value value) {
        checkBox.setSelected(value.asBoolean());
    }

    @Override
    public void setVisible(boolean visible) {
        this.checkBox.setVisible(visible);
    }

    @Override
    public Property<Value> getValueProperty() {
        return this.valueProperty;
    }

}
