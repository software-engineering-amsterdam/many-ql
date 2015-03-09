package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */
public class CalculationGrammarTest extends GrammarTest {

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
