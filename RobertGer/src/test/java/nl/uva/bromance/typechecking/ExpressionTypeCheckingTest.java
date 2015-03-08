package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.conditionals.Expression;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ExpressionTypeCheckingTest extends ASTTest {

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
        AST ast = createAst(content);
        List<Expression> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Expression.class);
        Expression question = questionList.get(1);
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
        AST ast = createAst(content);
        List<Expression> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Expression.class);
        Expression question = questionList.get(1);
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

        AST ast = createAst(getExpressionContent(operator));
        List<Expression> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Expression.class);
        Expression question = questionList.get(1);
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
