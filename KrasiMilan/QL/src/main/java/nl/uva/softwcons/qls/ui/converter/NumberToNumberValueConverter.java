package nl.uva.softwcons.qls.ui.converter;

import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public class NumberToNumberValueConverter implements ValueConverter<Number> {

    @Override
    public Value toValue(final Number value) {
        return new NumberValue(value);
    }

    @Override
    public Number fromValue(final Value value) {
        return value.getNumber();
    }

}
