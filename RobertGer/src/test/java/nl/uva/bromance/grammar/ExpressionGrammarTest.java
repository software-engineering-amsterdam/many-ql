package nl.uva.bromance.grammar;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */
public class ExpressionGrammarTest extends GrammarTest {

    private String parExpression = "(id)";

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


}
