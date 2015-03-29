package org.uva.student.calinwouter.qlqls.ql.helper;

public class QLGeneratorHelper {

    public static String form(String content) {
        return "form anyForm {" + content + "}";
    }

    /** Generates a question object according to QL's syntax. */
    public static String question(String identifier, String str, String type) {
        return identifier + ":" + " \"" + str + "\" " + type;
    }

    /** Generates a value object according to QL's syntax. */
    public static String value(String identifier, String str, String type, String expression) {
        return identifier + ":" + " \"" + str + "\" " + type + "(" + expression + ")";
    }

    private QLGeneratorHelper() {
    }

}
