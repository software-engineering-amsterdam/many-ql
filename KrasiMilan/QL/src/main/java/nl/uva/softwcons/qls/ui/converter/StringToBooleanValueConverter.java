package nl.uva.softwcons.qls.ui.converter;

import nl.uva.softwcons.ql.eval.value.BooleanValue;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public class StringToBooleanValueConverter implements ValueConverter<String> {
    private final String yes;
    private final String no;

    public StringToBooleanValueConverter(String yes, String no) {
        this.yes = yes;
        this.no = no;
    }

    @Override
    public Value toValue(String value) {
        return new BooleanValue(yes.equals(value));
    }

    @Override
    public String fromValue(Value value) {
        return value.getBoolean() ? yes : no;
    }

}
