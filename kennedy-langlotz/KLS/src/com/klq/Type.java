package com.klq;

/**
 * Created by Timon on 07.03.2015.
 */
//TODO add KLQ jar as dependency
public enum Type {
    SET, BOOLEAN, DATE, STRING, NUMERAL;

    public static Type getEnum(String type){
        switch (type){
            case "set": return SET;
            case "boolean": return BOOLEAN;
            case "date": return  DATE;
            case "string": return STRING;
            case "numeral": return NUMERAL;
        }
        throw new IllegalArgumentException("Unknown type");
    }
}
