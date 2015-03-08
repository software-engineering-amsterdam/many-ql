package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.Calculation;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Robert on 2/24/2015.
 */
public class CalculationTypeCheckingTest extends ASTTest {

    @Test
    public void correctCalculation() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_CALCULATION +
                "    }}}";

        AST ast = createAst(content);
        List<Calculation> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Calculation.class);
        Calculation question = questionList.get(1);
    }

    @Test
    public void calculationWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                " Calculation: {\n" +
                "}\n" +
                "}\n" +
                "}";
        AST ast = createAst(content);
        List<Calculation> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Calculation.class);
        Calculation question = questionList.get(1);
    }

    @Test
    public void calculationWithoutBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Calculation: \"calculation\"{" +
                "       }" +
                "    }}";

        AST ast = createAst(content);
        List<Calculation> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Calculation.class);
        Calculation question = questionList.get(1);

    }

    @Test
    public void multipleCorrectCalculations() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_CALCULATION +
                CORRECT_CALCULATION +
                "    }}";

        AST ast = createAst(content);
        List<Calculation> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Calculation.class);
        Calculation question = questionList.get(1);
    }
}
