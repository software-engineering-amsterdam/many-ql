package com.klq.gui;

import com.klq.logic.question.Type;

/**
 * Created by Timon on 25.02.2015.
 */
public class InputValidator {
    private static final String DATE = "\\d?\\d[\\./-]\\d?\\d[\\./-]\\d\\d\\d\\d";
    private static final String NUMBER = "-?\\d+(\\.\\d+)?";

    public static boolean matches(Type questionType, String input){
        if (input.trim().isEmpty())
            return true;
        switch (questionType){
            case NUMERAL:
                return matchesNumber(input);
            case DATE:
                return matchesDate(input);
            default:
                return true;
        }
    }

    private static boolean matchesDate(String input){
        if (input.matches(DATE))
            return true;
        return false;
    }

    private static boolean matchesNumber(String input){
        return input.matches(NUMBER);
    }
}
