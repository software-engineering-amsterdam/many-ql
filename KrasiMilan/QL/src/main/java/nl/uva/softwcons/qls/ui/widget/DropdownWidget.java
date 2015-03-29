package nl.uva.softwcons.qls.ui.widget;

import static javafx.collections.FXCollections.observableArrayList;
import static nl.uva.softwcons.qls.ui.widget.DropdownWidget.StringValueWrapper.NO_STRING_VALUE;
import static nl.uva.softwcons.qls.ui.widget.DropdownWidget.StringValueWrapper.NO_VALUE_WRAPPER;
import static nl.uva.softwcons.qls.ui.widget.DropdownWidget.StringValueWrapper.YES_STRING_VALUE;
import static nl.uva.softwcons.qls.ui.widget.DropdownWidget.StringValueWrapper.YES_VALUE_WRAPPER;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class DropdownWidget extends Widget {
    private ValueConverter<String> converter;
    private final ComboBox<StringValueWrapper> comboBox;

    public DropdownWidget(final String yesString, final String noString) {
        this.comboBox = new ComboBox<StringValueWrapper>(observableArrayList(new StringValueWrapper(YES_STRING_VALUE,
                yesString), new StringValueWrapper(NO_STRING_VALUE, noString)));
    }

    public DropdownWidget(final String yesString, final String noString, final ValueConverter<String> converter) {
        this(yesString, noString);
        this.converter = converter;
    }

    @Override
    public void addListener(final ValueChangeListener<Value> listener) {
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            listener.processValueChange(converter.toValue(newValue.toString()));
        });
    }

    @Override
    public void setValue(final Value value) {
        if (value.inConditionalContext()) {
            comboBox.setValue(YES_VALUE_WRAPPER);
            return;
        }

        comboBox.setValue(NO_VALUE_WRAPPER);
    }

    @Override
    public void setEditable(final boolean editable) {
        this.comboBox.setDisable(!editable);
    }

    @Override
    public Node getWidget() {
        return comboBox;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setConverter(final ValueConverter converter) {
        this.converter = converter;
    }

    public static final class StringValueWrapper {
        public static final String YES_STRING_VALUE = "YES";
        public static final String NO_STRING_VALUE = "NO";

        public static final StringValueWrapper YES_VALUE_WRAPPER = new StringValueWrapper(YES_STRING_VALUE, null);
        public static final StringValueWrapper NO_VALUE_WRAPPER = new StringValueWrapper(NO_STRING_VALUE, null);

        private final String label;
        private final String value;

        public StringValueWrapper(final String value, final String label) {
            this.label = label;
            this.value = value;
        }

        @Override
        public String toString() {
            return label;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((value == null) ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final StringValueWrapper other = (StringValueWrapper) obj;

            return value.equals(other.value);
        }

    }

}
