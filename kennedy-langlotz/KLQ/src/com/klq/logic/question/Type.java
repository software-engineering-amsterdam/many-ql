package com.klq.logic.question;

import com.klq.logic.IKLQItem;

/**
 * Created by Timon on 10.02.2015.
 */
public enum Type implements IKLQItem{
    SET, BOOLEAN, DATE, STRING, NUMERAL;

    public static Type getEnum(String type){
        switch (type){
            case "set": return SET;
            case "boolean": return BOOLEAN;
            case "date": return DATE;
            case "string": return STRING;
            case "numeral": return NUMERAL;
        }
        throw new IllegalArgumentException("Type not specified in class Type.");
    }
}
