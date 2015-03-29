package org.uva.student.calinwouter.qlqls.ql.helper;

import org.uva.student.calinwouter.qlqls.generated.node.*;

public class ASTHelper {

    public static String getIdentifier(AIdentifierExpression node) {
        final TIdentifier identifier = node.getIdentifier();
        return identifier.getText();
    }

    public static String getIdentifier(AQuestionStatement node) {
        final TIdentifier identifier = node.getIdentifier();
        return identifier.getText();
    }

    public static String getIdentifier(AValueStatement node) {
        final TIdentifier identifier = node.getIdentifier();
        return identifier.getText();
    }

    public static String getIdentifier(AIdentifierElement node) {
        final TIdentifier identifier = node.getIdentifier();
        return identifier.getText();
    }

    public static String getIdentifier(ANonParameterizedFunction node) {
        final TIdentifier identifier = node.getIdentifier();
        return identifier.getText();
    }

    public static String getIdentifier(AParameterizedFunction node) {
        final TIdentifier identifier = node.getIdentifier();
        return identifier.getText();
    }

    private static String removeQuotes(String string) {
        if (!string.startsWith("\"")) {
            return string;
        }
        final String stringWithRightQuote = string.substring(1);
        final Integer stringWithRightQuoteLength = stringWithRightQuote.length();
        return stringWithRightQuote.substring(0, stringWithRightQuoteLength - 1);
    }

    public static String getString(AQuestionStatement node) {
        final TString string = node.getString();
        final String stringWithQuotes = string.getText();
        return removeQuotes(stringWithQuotes);
    }

    public static Integer getNumber(ANumberElement node) {
        final TNumber number = node.getNumber();
        return Integer.parseInt(number.getText());
    }

    public static Integer getNumber(ANumberExpression node) {
        final TNumber number = node.getNumber();
        return Integer.parseInt(number.getText());
    }

    public static String getString(AValueStatement node) {
        TString string = node.getString();
        final String stringWithQuotes = string.getText();
        return removeQuotes(stringWithQuotes);
    }

    public static String getString(AStringElement node) {
        final TString string = node.getString();
        final String stringWithQuotes = string.getText();
        return removeQuotes(stringWithQuotes);
    }

    public static Integer getHex(AHexElement node) {
        final THex hex = node.getHex();
        final String hexStringWithHash = hex.getText();
        final String hexString = hexStringWithHash.substring(1);
        return Integer.parseInt(hexString, 16);
    }
}
