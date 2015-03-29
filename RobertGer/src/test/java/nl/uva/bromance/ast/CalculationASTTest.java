package nl.uva.bromance.ast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationASTTest extends ASTTest {

    @Test
    public void correctCalculation() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_CALCULATION +
                "    }}}";

        AST ast = createAst(content);
        List<Calculation> calculationList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Calculation.class);
        Calculation calculation = calculationList.get(0);

        assertThat(calculation.hasChildren()).isTrue();
        assertThat(calculation.getLineNumber()).isEqualTo(3);
    }

    @Test
    public void multipleCorrectCalculations() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_CALCULATION +
                CORRECT_CALCULATION +
                "    }}";

        AST ast = createAst(content);
        List<Calculation> calculationList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Calculation.class);

        assertThat(calculationList).hasSize(2);
    }
}
