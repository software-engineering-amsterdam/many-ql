package nl.uva.softwcons.ql.ui.widget;

import javafx.scene.control.CheckBox;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public class CheckboxWidget extends Widget {
    private final CheckBox checkBox;
    private final ValueConverter<Boolean> converter;

    public CheckboxWidget(final String checkString, final ValueConverter<Boolean> converter) {
        this.checkBox = new CheckBox(checkString);
        this.converter = converter;
    }

    @Override
    public CheckBox getWidget() {
        return checkBox;
    }

    @Override
    public void setValue(final Value value) {
        checkBox.setSelected(value.inConditionalContext());
    }

    @Override
    public void setEditable(final boolean editable) {
        this.checkBox.setDisable(!editable);
    }

    @Override
    public void addListener(final ValueChangeListener<Value> listener) {
        this.checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            listener.processValueChange(converter.toValue(newValue));
        });
    }

}
