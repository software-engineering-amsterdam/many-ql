package nl.uva.softwcons.qls.ui.converter;

import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;
import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public class NumberToNumberValueConverter implements ValueConverter<Number> {
    private final Double start;

    public NumberToNumberValueConverter(final double start) {
        this.start = start;
    }

    @Override
    public Value toValue(final Number value) {
        return new NumberValue(value);
    }

    @Override
    public Number fromValue(final Value value) {
        if (value == UNDEFINED) {
            return start;
        }

        return value.getNumber();
    }

}
