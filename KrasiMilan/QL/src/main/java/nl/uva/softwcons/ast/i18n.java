package nl.uva.softwcons.ast;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class i18n {
    private static ResourceBundle MESSAGES = ResourceBundle.getBundle("locale.messages");

    public static String _i(final String originalStr, Object... params) {
        try {
            return MessageFormat.format(MESSAGES.getString(originalStr), params);
        } catch (MissingResourceException e) {
            return originalStr;
        }
    }

}
