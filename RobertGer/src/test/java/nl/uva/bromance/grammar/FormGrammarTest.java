package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


public class FormGrammarTest extends GrammarTest {

    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n";
        END = "}}";
    }

    @Test
    public void correctForm() throws IOException {

        walker.walk(listener, createTree(CORRECT_FORM_SETUP));
    }


    @Test
    public void formWithoutBodyContent() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n" +
                "    }" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void malformedForm() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n" +
                "    " +
                "}";
        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void formWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form:  {\n" +
                "\n" +
                "    }" +
                "}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @Test
    public void multipleForms() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                CORRECT_FORM +
                CORRECT_FORM +
                "}";
        walker.walk(listener, createTree(content));

        assertThat(listener.formCount).isEqualTo(2);
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
