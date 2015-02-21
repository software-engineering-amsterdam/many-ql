package helper;

public class TestHelper {

    private TestHelper() {
    }

    public static String buildForm(final String formName, final String... statements) {
        return String.format("form %s { %s }", formName, String.join(" ", statements));
    }
}
