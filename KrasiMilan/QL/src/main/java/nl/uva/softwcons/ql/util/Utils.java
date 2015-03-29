package nl.uva.softwcons.ql.util;

public final class Utils {

    // Suppresses default constructor, ensuring non-instantiability.
    private Utils() {
    }

    /**
     * This String utility method removes single or double quotes from a string
     * if its quoted.
     * 
     * @param String
     *            value to be unquoted.
     * @return value unquoted
     *
     */
    public static String unquote(final String str) {

        if ((str.startsWith("\"") && str.endsWith("\"")) || (str.startsWith("'") && str.endsWith("'"))) {
            return str.substring(1, str.length() - 1);
        }

        return str;
    }

}
