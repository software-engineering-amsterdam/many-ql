package org.uva.student.calinwouter.qlqls.ql.helper;

public class QLGeneratorHelper {

    public static String form(String content) {
        return "form anyForm {" + content + "}";
    }

    public static String question(String identifier, String str, String type) {
        return identifier + ":" + " \"" + str + "\" " + type;
    }

    public static String value(String identifier, String str, String type, String expression) {
        // c: "c:" int(a - b)
        return identifier + ":" + " \"" + str + "\" " + type + "(" + expression + ")";
    }

    private QLGeneratorHelper() {
    }

}
