package nl.uva.softwcons.ql.ui.converter;

import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;

import java.math.BigDecimal;

import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.Value;

public class StringToNumberValueConverter implements ValueConverter<String> {

    @Override
    public Value toValue(final String value) {
        if (value.isEmpty()) {
            return UNDEFINED;
        }

        return new NumberValue(new BigDecimal(value));
    }

    @Override
    public String fromValue(final Value value) {
        if (value == UNDEFINED) {
            return "";
        }

        return value.getNumber().toPlainString();
    }

}
