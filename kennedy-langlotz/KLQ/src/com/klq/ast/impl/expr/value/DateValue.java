package com.klq.ast.impl.expr.value;

import java.util.Date;

/**
 * Created by Timon on 03.03.2015.
 */
public class DateValue extends ComparableValue<Date> {

    public DateValue(Date value) {
        super(value);
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}
