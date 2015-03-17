package com.klq.ast.impl.expr;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.value.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Timon on 27.02.2015.
 */
public class ExpressionUtil {
    private final static DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public static Value createTerminalFromString(Type type, String value){
        if (value.trim().isEmpty()){
            return new UndefinedValue();
        }
        switch (type){
            case BOOLEAN:
                return createBooleanFromString(value);
            case DATE:
                return createDateFromString(value);
            case NUMERAL:
                return createNumberFromString(value);
            case STRING:
                return new StringValue(value);
        }
        throw new IllegalArgumentException("Type is not a valid type! Type: " + type);
    }

    private static BooleanValue createBooleanFromString(String value){
        String normalized = value.toLowerCase().trim();
        if (normalized.equals("yes") || normalized.equals("true")) {
            return new BooleanValue(true);
        } else if (normalized.equals("no") || normalized.equals("false")) {
            return new BooleanValue(false);
        }
        throw new IllegalArgumentException("Argument not a boolean. Arguemnt: " + value);
    }

    private static DateValue createDateFromString(String value){
        String[] splitValues = value.split("[\\./-]");
        splitValues = addZeros(splitValues);
        Date date;
        try {
            if (splitValues[0].length() == 2 && splitValues[1].length() == 2 && splitValues[2].length() == 4) {
                date = SDF.parse(splitValues[2] + "-" + splitValues[1] + "-" + splitValues[0]);
            } else {
                date = SDF.parse(splitValues[0] + "-" + splitValues[1] + "-" + splitValues[2]);
            }
            return new DateValue(date);
        } catch (ParseException p) {
            throw new IllegalArgumentException("Argument not a date. Argument: " + value);
        }
    }

    private static String[] addZeros(String[] dateArray){
        String[] result = dateArray.clone();
        for (int i = 0; i < result.length; i++) {
            if (result[i].length() == 1)
                result[i] = "0" + result[i];
        }
        return result;
    }

    private static NumberValue createNumberFromString(String value){
        try {
            return new NumberValue(new BigDecimal(value));
        } catch (Exception e){
            throw new IllegalArgumentException("Argument not a number. Argument: " + value);
        }
    }
}
