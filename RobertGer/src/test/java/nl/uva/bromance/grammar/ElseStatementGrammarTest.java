package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ElseStatementGrammarTest extends GrammarTest {

    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                " Else: {";
        END = "}}}";
    }

    @org.junit.Test
    public void correctElse() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.elseStatementCount).isEqualTo(1);
    }

    @org.junit.Test
    public void elseStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "\n     Else:{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void elseWithoutPrecedingIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_ELSE +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void elseWithoutBodyContent() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                "     Else:{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @org.junit.Test
    public void malformedElseStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "     Else:{" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    //Test all grammar types as children (by testing all possible types for all possible children we are by extension testing all possible types for all possible parents)
    @Test
    public void CalculationAsChild() throws IOException {
        CalculationAsChildSetup();

        assertThat(listener.elseStatementCount).isEqualTo(1);
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

        assertThat(listener.elseStatementCount).isEqualTo(1);
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

        assertThat(listener.elseStatementCount).isEqualTo(1);
        assertThat(listener.questionCount).isEqualTo(1);
    }

    @Test
    public void QuestionnaireAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        QuestionnaireAsChildSetup();
    }
}
