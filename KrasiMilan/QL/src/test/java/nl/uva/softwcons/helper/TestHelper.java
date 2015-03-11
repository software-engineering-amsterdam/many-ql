package nl.uva.softwcons.helper;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;

public final class TestHelper {
    public static final LineInfo DUMMY_LINE_INFO = new LineInfo(-1, -1);
    public static final Identifier UNUSED = new Identifier("unused", DUMMY_LINE_INFO);
    public static final Identifier QUESTION = new Identifier("question", DUMMY_LINE_INFO);
    public static final Identifier QUESTION2 = new Identifier("question2", DUMMY_LINE_INFO);
    public static final Identifier QUESTION3 = new Identifier("question3", DUMMY_LINE_INFO);

    private TestHelper() {
    }

    public static String buildForm(final String formName, final String... statements) {
        return String.format("form %s {%n %s %n}", formName, String.join("\n", statements));
    }

    public static String buildStylesheet(final String stylesheetName, final String... pages) {
        return String.format("stylesheet %s {%n %s %n}", stylesheetName, String.join(" ", pages));
    }
}
