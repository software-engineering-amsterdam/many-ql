package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionGrammarTest extends GrammarTest {

    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Answer: integer" +
                "Text: \" How much money did you earn through employer paid wages during 2014 ? \"";
        END = "}}}";
    }

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

    //Test all grammar types as children (by testing all possible types for all possible children we are by extension testing all possible types for all possible parents)
    @Test
    public void CalculationAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        CalculationAsChildSetup();
    }

    @Test
    public void ExpressionAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        ExpressionAsChildSetup();
    }

    @Test
    public void FormAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        FormAsChildSetup();
    }

    @Test
    public void IfStatementAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        IfStatementAsChildSetup();
    }

    @Test
    public void ElseIfStatementAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        ElseIfStatementAsChildSetup();
    }

    @Test
    public void ElseStatementAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        ElseStatementAsChildSetup();
    }

    @Test
    public void InputAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        InputAsChildSetup();

    }

    @Test
    public void LabelAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        LabelAsChildSetup();
    }

    @Test
    public void QuestionAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        QuestionAsChildSetup();
    }

    @Test
    public void QuestionnaireAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        QuestionnaireAsChildSetup();
    }
}
