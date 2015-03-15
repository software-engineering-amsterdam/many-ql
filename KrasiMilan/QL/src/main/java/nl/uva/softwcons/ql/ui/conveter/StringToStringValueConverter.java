package nl.uva.softwcons.ql.ui.conveter;

import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;
import nl.uva.softwcons.ql.eval.value.StringValue;
import nl.uva.softwcons.ql.eval.value.Value;

public class StringToStringValueConverter implements ValueConverter<String> {

    @Override
    public Value toValue(final String value) {
        if (value.isEmpty()) {
            return UNDEFINED;
        }

        return new StringValue(value);
    }

    @Override
    public String fromValue(final Value value) {
        return value.asString();
    }

}
