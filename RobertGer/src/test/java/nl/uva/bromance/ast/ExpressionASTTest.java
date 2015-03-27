package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.operators.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionASTTest extends ASTTest {

    private String parExpression = "(id)";

    @Test
    public void correctIdExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If: identifier {\n" +
                "            Text: \"text\"\n" +
                "      }\n" +
                "   }\n" +
                "}\n";
        AST ast = createAst(content);
        List<Expression> expressionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Expression.class);
        Expression expression = expressionList.get(0);

        assertThat(expressionList).hasSize(1);
        assertThat(expression.getLineNumber()).isEqualTo(3);
    }

    @Test
    public void correctParExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If:" + parExpression + "{\n" +
                "            Text: \"text\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
        AST ast = createAst(content);
        List<Expression> expressionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Expression.class);
        Expression expression = expressionList.get(0);

        assertThat(expressionList).hasSize(1);
        assertThat(expression.getLineNumber()).isEqualTo(3);
        assertThat(expression.hasChildren()).isTrue();
    }

    @Test
    public void correctTimesExpression() throws IOException {
        assertExpressionOperator("*", new MultiplyOperator());
    }

    @Test
    public void correctDivisionExpression() throws IOException {
        assertExpressionOperator("/", new DivideOperator());
    }

    @Test
    public void correctAdditionExpression() throws IOException {
        assertExpressionOperator("+", new PlusOperator());
    }

    @Test
    public void correctSubtractionExpression() throws IOException {
        assertExpressionOperator("-", new MinusOperator());
    }

    @Test
    public void correctEqualsExpression() throws IOException {
        assertExpressionOperator("==", new EqualsOperator());
    }

    @Test
    public void correctNotEqualsExpression() throws IOException {
        assertExpressionOperator("!=", new NotEqualsOperator());
    }

    @Test
    public void correctBiggerThanOrEqualExpression() throws IOException {
        assertExpressionOperator(">=", new LargerThanOrEqualsOperator());
    }

    @Test
    public void correctLessThanOrEqualExpression() throws IOException {
        assertExpressionOperator("<=", new SmallerThanOrEqualsOperator());
    }

    @Test
    public void correctBiggerThanExpression() throws IOException {
        assertExpressionOperator(">", new LargerThanOperator());
    }

    @Test
    public void correctLessThanExpression() throws IOException {
        assertExpressionOperator("<", new SmallerThanOperator());
    }

    @Test
    public void correctOrExpression() throws IOException {
        assertExpressionOperator("||", new OrOperator());
    }

    @Test
    public void correctAndExpression() throws IOException {
        assertExpressionOperator("&&", new AndOperator());
    }

    private void assertExpressionOperator(String operator, Operator operatorType
    ) throws IOException {

        AST ast = createAst(getExpressionContent(operator));
        List<Expression> expressionList = ast.getAllChildrenOfType_ForAst(Expression.class);

        assertThat(expressionList).hasSize(3);
        assertThat(expressionList.get(0).getOperator().isPresent()).isTrue();
        assertThat(expressionList.get(0).getOperator().get().getClass()).isEqualTo(operatorType.getClass());
    }

    /*Note that the identifiers here represent a terminal and that they could be replaced by any expression tested above.
    Testing all possible combinations of expressions however is A LOT of tests. So only basic expressions are tested.
    */
    private String getExpressionContent(String operator) {
        return "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "         If: identifier" + operator + " identifier {\n" +
                "            Text: \"text\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
    }


}
