package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */
public class CalculationGrammarTest extends GrammarTest {

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }

    @Test
    public void correctCalculation() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_CALCULATION +
                "    }}}";

        walker.walk(listener, createTree(content));

        assertThat(listener.calculationCount).isEqualTo(1);
    }

    @Test
    public void calculationWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: {\n" +
                "}\n" +
                "}\n" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void calculationWithoutBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Calculation: \"calculation\"{" +
                "       }" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @Test
    public void questionWithoutAnswerType() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "    }}}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void malformedQuestion() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void questionWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: {" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "           Answer: integer" +
                "       }" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void multipleCorrectCalculations() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_CALCULATION +
                CORRECT_CALCULATION +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.calculationCount).isEqualTo(2);
    }
}
