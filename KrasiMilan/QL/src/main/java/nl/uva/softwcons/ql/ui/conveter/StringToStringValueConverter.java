package nl.uva.softwcons.ql.ui.conveter;

import nl.uva.softwcons.ql.eval.value.StringValue;
import nl.uva.softwcons.ql.eval.value.Value;

public class StringToStringValueConverter implements ValueConverter<String> {

    @Override
    public Value toValue(final String value) {
        return new StringValue(value);
    }

}
