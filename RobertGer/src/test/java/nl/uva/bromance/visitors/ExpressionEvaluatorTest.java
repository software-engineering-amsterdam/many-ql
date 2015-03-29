package nl.uva.bromance.visitors;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.ExpressionEvaluator;
import nl.uva.bromance.ast.conditionals.IntResult;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ExpressionEvaluatorTest extends ASTTest {

    @Test
    public void testPlusOperator() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"formidentifier\" {\n" +
                "Calculation: \"identifier\" {" +
                "Input: 1+1}" +
                "    }\n" +
                "}";
        AST<QLNode> ast = createAst(content);

        new ExpressionEvaluator(null).evaluate(ast.getRoot());

        List<Expression> expressions = ast.getAllChildrenOfType_ForAst(Expression.class);
        assertThat(expressions.get(0).getResult()).isInstanceOf(IntResult.class);
        assertThat(expressions.get(1).getResult()).isInstanceOf(IntResult.class);
        assertThat(expressions.get(2).getResult()).isInstanceOf(IntResult.class);
    }
}
