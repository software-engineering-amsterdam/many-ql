package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LabelGrammarTest extends GrammarTest {

    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "Label: \"identifier\"{";
        END = "}}}";
    }

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
        IfStatementAsChildSetup();

        assertThat(listener.labelCount).isEqualTo(1);
        assertThat(listener.ifStatementCount).isEqualTo(1);
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
