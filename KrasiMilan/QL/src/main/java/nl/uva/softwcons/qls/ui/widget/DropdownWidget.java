package nl.uva.softwcons.qls.ui.widget;

import static javafx.collections.FXCollections.observableArrayList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class DropdownWidget extends Widget {
    private final ValueConverter<String> converter;
    private final ComboBox<String> comboBox;

    private final String yesValue;
    private final String noValue;

    public DropdownWidget(final String yesString, final String noString, final ValueConverter<String> converter) {
        this.converter = converter;

        this.yesValue = yesString;
        this.noValue = noString;

        comboBox = new ComboBox<String>(observableArrayList(yesString, noString));
    }

    @Override
    public void addListener(ValueChangeListener<Value> listener) {
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            listener.processValueChange(converter.toValue(newValue));
        });
    }

    @Override
    public void setValue(Value value) {
        if (value.inConditionalContext()) {
            comboBox.setValue(yesValue);
            return;
        }
        comboBox.setValue(noValue);
    }

    @Override
    public void setEditable(boolean editable) {
        this.comboBox.setDisable(!editable);
    }

    @Override
    public Node getWidget() {
        return comboBox;
    }

}
