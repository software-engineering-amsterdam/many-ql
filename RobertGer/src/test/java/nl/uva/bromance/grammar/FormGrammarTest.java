package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 10-2-2015.
 */
public class FormGrammarTest extends GrammarTest {

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }

    @Test
    public void questionnaireWithoutForms() throws IOException {
        String content = "Name: \"Tax\" {}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void correctForm() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                CORRECT_FORM +
                "}";

        walker.walk(listener, createTree(content));
    }


    @Test
    public void formWithoutBodyContent() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n" +
                "    }" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void formHasMalformedFormBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n" +
                "    " +
                "}";
        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void formHasNoIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form:  {\n" +
                "\n" +
                "    }" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void containsMultipleForms() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                CORRECT_FORM +
                CORRECT_FORM +
                "}";
        walker.walk(listener, createTree(content));

        assertThat(listener.formCount).isEqualTo(2);
    }

    @Test
    public void formContainsCalculationWithoutBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: \"{}" +
                "}" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void malformedCalculation() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: {" +
                "       }" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }
}
