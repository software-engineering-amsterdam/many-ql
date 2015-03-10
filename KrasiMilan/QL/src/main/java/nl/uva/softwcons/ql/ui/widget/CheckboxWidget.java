package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.conveter.ValueConverter;

public class CheckboxWidget extends Widget {
    private CheckBox checkBox;
    private Property<Value> valueProperty;

    public CheckboxWidget(final String checkString, final ValueConverter<Boolean> converter) {
        this.checkBox = new CheckBox(checkString);
        this.valueProperty = new SimpleObjectProperty<Value>();

        this.checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                valueProperty.setValue(converter.toValue(newValue));
            }
        });
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
