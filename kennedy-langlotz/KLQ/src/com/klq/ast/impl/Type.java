package com.klq.ast.impl;

import com.klq.logic.IKLQItem;

/**
 * Created by Timon on 10.02.2015.
 */
public enum Type implements IKLQItem{
    BOOLEAN, DATE, STRING, NUMERAL;

    public static Type getEnum(String type){
        switch (type){
            case "boolean": return BOOLEAN;
            case "date": return DATE;
            case "string": return STRING;
            case "numeral": return NUMERAL;
        }
        throw new IllegalArgumentException("Type not specified in class Type.");
    }
}
