package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 3/2/2015.
 */
public class QuestionnaireGrammarTest extends GrammarTest {


    @Test
    public void correctQuestionnaire() throws IOException {

        walker.walk(listener, createTree(CORRECT_QUESTIONNAIRE));

        assertThat(listener.questionnaireCount).isEqualTo(1);
    }

    @Test
    public void questionnaireWithoutForms() throws IOException {
        String content = "Name: \"Tax\" {}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void malformedQuestionnaire() throws IOException {
        String content = "Name: \"Tax\" {" +
                CORRECT_FORM;

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void questionnaireWithoutIdentifier() throws IOException {

        String content = "Name: {" + CORRECT_FORM + "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }
}
