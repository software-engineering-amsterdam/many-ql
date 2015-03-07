package com.klq.ast.impl.expr;

import com.klq.logic.question.Type;
import com.klq.logic.value.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Timon on 27.02.2015.
 */
public class ExpressionUtil {
    private final static DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public static Value createTerminalFromString(Type type, String value){
        switch (type){
            case BOOLEAN:
                return createBooleanFromString(value);
            case DATE:
                return createDateFromString(value);
            case NUMERAL:
                return createNumberFromString(value);
            case STRING:
            case SET:
                return new StringValue(value);
        }
        return null;
    }

    private static BooleanValue createBooleanFromString(String value){
        String normalized = value.toLowerCase().trim();
        if (normalized.equals("yes") || normalized.equals("true"))
            return new BooleanValue(true);
        return new BooleanValue(false);
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
        } catch (ParseException p) {
            date = new Date();
            System.err.println("Error while parsing date!");
            p.printStackTrace();
        }
        return new DateValue(date);
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
        return new NumberValue(new BigDecimal(value));
    }
}
