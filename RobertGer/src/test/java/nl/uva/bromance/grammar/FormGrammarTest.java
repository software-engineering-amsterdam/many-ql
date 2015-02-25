package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 10-2-2015.
 */
public class FormGrammarTest {

    private FakeGrammarListener listener;
    private ParseTreeWalker walker;

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void questionnaireWithoutForms() throws IOException {
        String content = "Name: \"Tax\" {}";

        walker.walk(listener, createTree(content));
    }

    @Test
    public void correctForm() throws IOException

    {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "       Label: \"something\"{" +
                "           Text: \"something\"" +
                "      }" +
                "   }" +
                "}";

        walker.walk(listener, createTree(content));
    }


    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void formWithoutBodyContent() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n" +
                "    }" +
                "}";

        walker.walk(listener, createTree(content));

        assertThat(listener.formCount).isEqualTo(1);
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void formHasMalformedFormBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n" +
                "    " +
                "}";

        walker.walk(listener, createTree(content));
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void formHasNoIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form:  {\n" +
                "\n" +
                "    }" +
                "}";

        walker.walk(listener, createTree(content));
    }

    @Test
    public void containsMultipleForms() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "       Label: \"something\"{" +
                "           Text: \"something\"" +
                "      }" +
                "    }" +
                "    Form: \"default\" {\n" +
                "       Label: \"something\"{" +
                "           Text: \"something\"" +
                "      }" +
                "    }" +
                "}";
        walker.walk(listener, createTree(content));

        assertThat(listener.formCount).isEqualTo(2);
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void formContainsCalculationWithoutBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: \"{}" +
                "}" +
                "}";

        walker.walk(listener, createTree(content));
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void malformedCalculation() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: {" +
                "       }" +
                "}";

        walker.walk(listener, createTree(content));
    }

    @Test
    public void correctCalculation() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: \"name\"{\n" +
                "Input: income1 * 0.43 }\n" +
                "}\n" +
                "}";

        walker.walk(listener, createTree(content));
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void calculationWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: {\n" +
                "}\n" +
                "}\n" +
                "}";

        walker.walk(listener, createTree(content));
    }

    private static QLParser.QuestionnaireContext createTree(String content) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(new ByteArrayInputStream(content.getBytes())));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new GrammarErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new GrammarErrorListener());
        return parser.questionnaire();
    }


    static class FakeGrammarListener extends QLParseTreeListener {
        public int formCount = 0;
        public int questionnaireCount = 0;

        @Override
        public void exitForm(QLParser.FormContext ftx) {
            super.exitForm(ftx);
            formCount += 1;
        }

        @Override
        public void exitQuestionnaire(QLParser.QuestionnaireContext ctx) {
            super.exitQuestionnaire(ctx);
            questionnaireCount += 1;
        }
    }


}
