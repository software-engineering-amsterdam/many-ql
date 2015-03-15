package nl.uva.softwcons.ql.ui.conveter;

import nl.uva.softwcons.ql.eval.value.BooleanValue;
import nl.uva.softwcons.ql.eval.value.Value;

public class BooleanToBooleanValueConverter implements ValueConverter<Boolean> {

    @Override
    public Value toValue(final Boolean value) {
        return new BooleanValue(value);
    }

    @Override
    public Boolean fromValue(final Value value) {
        return value.asBoolean();
    }

}
