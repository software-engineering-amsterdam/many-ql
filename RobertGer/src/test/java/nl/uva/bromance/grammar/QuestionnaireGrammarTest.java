package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionnaireGrammarTest extends GrammarTest {


    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {";
        END = "}";
    }

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
        FormAsChildSetup();

        assertThat(listener.questionnaireCount).isEqualTo(1);
        assertThat(listener.formCount).isEqualTo(1);

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
