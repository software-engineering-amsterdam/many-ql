package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionGrammarTest extends GrammarTest {

    private String parExpression = "(id)";

    @Before
    public void setupStartEnd() {
        START = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If: expression *";
        END = "{Text: \"text\" }}}";
    }

    @Test
    public void correctIdExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If: identifier {" +
                "            Text: \"text\"" +
                "      }" +
                "   }" +
                "}";

        walker.walk(listener, createTree(content));

        assertThat(listener.expressionCount).isEqualTo(1);
    }

    @Test
    public void correctParExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If:" + parExpression + "{" +
                "            Text: \"text\"" +
                "      }" +
                "   }" +
                "}";
        walker.walk(listener, createTree(content));

        assertThat(listener.expressionCount).isEqualTo(2);
    }

    @Test
    public void correctTimesExpression() throws IOException {
        assertExpressionOperator("*");
    }

    @Test
    public void correctDivisionExpression() throws IOException {
        assertExpressionOperator("/");
    }

    @Test
    public void correctAdditionExpression() throws IOException {
        assertExpressionOperator("+");
    }

    @Test
    public void correctSubtractionExpression() throws IOException {
        assertExpressionOperator("-");
    }

    @Test
    public void correctEqualsExpression() throws IOException {
        assertExpressionOperator("==");
    }

    @Test
    public void correctNotEqualsExpression() throws IOException {
        assertExpressionOperator("!=");
    }

    @Test
    public void correctBiggerThanOrEqualExpression() throws IOException {
        assertExpressionOperator(">=");
    }

    @Test
    public void correctLessThanOrEqualExpression() throws IOException {
        assertExpressionOperator("<=");
    }

    @Test
    public void correctBiggerThanExpression() throws IOException {
        assertExpressionOperator(">");
    }

    @Test
    public void correctLessThanExpression() throws IOException {
        assertExpressionOperator("<");
    }

    @Test
    public void correctOrExpression() throws IOException {
        assertExpressionOperator("||");
    }

    @Test
    public void correctAndExpression() throws IOException {
        assertExpressionOperator("&&");
    }

    private void assertExpressionOperator(String operator) throws IOException {

        walker.walk(listener, createTree(getExpressionContent(operator)));

        assertThat(listener.expressionCount).isEqualTo(3);
    }

    /*Note that the identifiers here represent a terminal and that they could be replaced by any expression tested above.
    Testing all possible combinations of expressions however is A LOT of tests. So only basic expressions are tested.
    */
    private String getExpressionContent(String operator) {
        return "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If: identifier" + operator + " identifier {" +
                "            Text: \"text\"" +
                "      }" +
                "   }" +
                "}";
    }


    //Test all grammar types as children (by testing all possible types for all possible children we are by extension testing all possible types for all possible parents)
    @Test
    public void CalculationAsChild() throws IOException {
        expectedException.expect(GrammarErrorListener.SyntaxError.class);
        CalculationAsChildSetup();
    }

    @Test
    public void ExpressionAsChild() throws IOException {
        ExpressionAsChildSetup();
        assertThat(listener.expressionCount).isEqualTo(3);
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
