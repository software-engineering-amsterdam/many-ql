package nl.uva.softwcons.helper;

import java.util.List;
import java.util.function.Function;

import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.validation.Error;

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

    /**
     * Builds a Form called always "form1" with the given statements (separating
     * them by newlines), runs the given checker function and returns the list
     * of found errors.
     * 
     * @param formContents
     *            The statements that will be included in the form
     * @param checker
     *            The method reference to a checker function that is used
     *            against the form
     * @return Any errors found by the checker
     */
    public static List<Error> getCheckerErrors(Function<Form, List<Error>> checker, final String... formContents) {
        final Form form = Questionnaire.build(TestHelper.buildForm("form1", formContents));

        return checker.apply(form);
    }

}
