package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LabelGrammarTest extends GrammarTest {

    private static final String CORRECT_LABEL = "Label: \"identifier\"{ Text: \"something\"}";

    @Test
    public void correctLabel() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_LABEL +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.labelCount).isEqualTo(1);
    }

    @Test
    public void malformedLabel() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "Label: \"identifier\"{ Text: \"something\"" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @Test
    public void labelWithoutIdentifier() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "Label: { Text: \"something\"" +
                "    }}";


        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }
}
