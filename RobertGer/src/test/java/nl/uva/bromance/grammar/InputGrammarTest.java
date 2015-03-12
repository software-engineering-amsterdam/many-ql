package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class InputGrammarTest extends GrammarTest {

    private static final String CORRECT_INPUT = "Input: expression";

    @Test
    public void correctInput() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                CORRECT_INPUT +
                "   }}}";

        walker.walk(listener, createTree(content));

        assertThat(listener.inputCount).isEqualTo(1);
    }

    @Test
    public void incorrectParent() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_INPUT +
                "   }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }


}
