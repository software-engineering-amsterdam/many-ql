package com.klq.ast.impl.value;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Timon on 03.03.2015.
 */
public class DateValue extends ComparableValue<Date> {
    private final DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public DateValue(Date value) {
        super(value);
    }

    @Override
    public String toString() {
        return SDF.format(getValue());
    }
}
