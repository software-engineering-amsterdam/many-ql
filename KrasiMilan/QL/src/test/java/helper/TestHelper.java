package helper;

import nl.uva.softwcons.ast.LineInfo;

public class TestHelper {

    private TestHelper() {
    }

    public static final LineInfo DUMMY_LINE_INFO = new LineInfo(-1, -1);

    public static String buildForm(final String formName, final String... statements) {
        return String.format("form %s {\n%s\n}", formName, String.join("\n", statements));
    }
}
