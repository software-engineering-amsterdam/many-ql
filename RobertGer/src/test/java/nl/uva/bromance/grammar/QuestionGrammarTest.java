package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */
public class QuestionGrammarTest extends GrammarTest {
    @Test
    public void question() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_QUESTION +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.questionCount).isEqualTo(1);
    }

    @Test
    public void questionWithoutText() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Answer: integer" +
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
    public void formContainsMultipleQuestions() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_QUESTION +
                CORRECT_QUESTION +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.questionCount).isEqualTo(2);
    }
}
