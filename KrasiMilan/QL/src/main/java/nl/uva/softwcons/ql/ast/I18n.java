package nl.uva.softwcons.ql.ast;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class I18n {

    private I18n() {
    }

    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("locale.messages");

    public static String i(final String originalStr, Object... params) {
        try {
            return MessageFormat.format(MESSAGES.getString(originalStr), params);
        } catch (MissingResourceException e) {
            return originalStr;
        }
    }

}
