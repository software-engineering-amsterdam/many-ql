package nl.uva.softwcons.ql.ui.conveter;

import java.math.BigDecimal;

import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.Value;

public class StringToNumberValueConverter implements ValueConverter<String> {

    @Override
    public Value toValue(final String value) {
        return new NumberValue(new BigDecimal(value));
    }

}
