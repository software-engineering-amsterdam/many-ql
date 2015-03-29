package nl.uva.softwcons.qls.ui.converter;

import static nl.uva.softwcons.qls.ui.widget.DropdownWidget.StringValueWrapper.NO_STRING_VALUE;
import static nl.uva.softwcons.qls.ui.widget.DropdownWidget.StringValueWrapper.YES_STRING_VALUE;
import nl.uva.softwcons.ql.eval.value.BooleanValue;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public class StringToBooleanValueConverter implements ValueConverter<String> {

    @Override
    public Value toValue(final String value) {
        return new BooleanValue(YES_STRING_VALUE.equals(value));
    }

    @Override
    public String fromValue(final Value value) {
        return value.getBoolean() ? YES_STRING_VALUE : NO_STRING_VALUE;
    }
}
