package com.klq.ast.impl;

import com.klq.gui.IKLQItem;

/**
 * Created by Timon on 10.02.2015.
 */
public enum Type implements IKLQItem{
    BOOLEAN, DATE, STRING, NUMERAL, UNDEFINED;

    public static Type getEnum(String type){
        switch (type){
            case "boolean": return BOOLEAN;
            case "date": return DATE;
            case "string": return STRING;
            case "numeral": return NUMERAL;
            case "undefined": return UNDEFINED;
        }
        throw new IllegalArgumentException("Type not specified in class Type.");
    }
}
