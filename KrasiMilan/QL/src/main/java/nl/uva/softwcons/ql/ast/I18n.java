package nl.uva.softwcons.ql.ast;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class I18n {
    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("locale.messages");

    private I18n() {
    }

    public static String i(final String originalStr, final Object... params) {
        try {
            return MessageFormat.format(MESSAGES.getString(originalStr), params);
        } catch (MissingResourceException e) {
            return originalStr;
        }
    }

}
