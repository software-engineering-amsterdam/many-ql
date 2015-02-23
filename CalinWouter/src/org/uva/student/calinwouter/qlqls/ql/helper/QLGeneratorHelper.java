package org.uva.student.calinwouter.qlqls.ql.helper;

public class QLGeneratorHelper {

    public static String form(String content) {
        return "form anyForm {" + content + "}";
    }

    public static String question(String ident, String str, String type) {
        return ident + ":" + " \"" + str + "\" " + type;
    }

    public static String value(String ident, String str, String type, String exp) {
        // c: "c:" int(a - b)
        return ident + ":" + " \"" + str + "\" " + type + "(" + exp + ")";
    }

    private QLGeneratorHelper() {}

}
