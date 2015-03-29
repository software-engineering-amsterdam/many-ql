package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 15-3-2015.
 */
public class IfStatementGrammarTest extends GrammarTest {


    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " If: expression {";
        END = "}}}";
    }

    //Check if statement
    @org.junit.Test
    public void correctIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "}}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
    }


    @org.junit.Test
    public void ifStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @org.junit.Test
    public void malformedIfStatementBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void ifStatementHasNoExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: { Text: \"something\" }" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void multipleIfStatements() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_IF +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(2);
    }

    //Test all grammar types as children (by testing all possible types for all possible children we are by extension testing all possible types for all possible parents)
    @Test
    public void CalculationAsChild() throws IOException {
        CalculationAsChildSetup();

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.calculationCount).isEqualTo(1);
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
        InputAsChildSetup();

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.inputCount).isEqualTo(1);
    }

    @Test
    public void LabelAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        LabelAsChildSetup();

    }

    @Test
    public void QuestionAsChild() throws IOException {
        QuestionAsChildSetup();

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.questionCount).isEqualTo(1);
    }

    @Test
    public void QuestionnaireAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        QuestionnaireAsChildSetup();
    }
}
