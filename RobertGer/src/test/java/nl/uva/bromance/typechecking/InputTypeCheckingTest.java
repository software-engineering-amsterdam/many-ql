package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.Input;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class InputTypeCheckingTest extends ASTTest {

    private static final String CORRECT_INPUT = "Input: expression";

    @Test
    public void correctInput() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                CORRECT_INPUT +
                "   }}}";

        AST ast = createAst(content);
        List<Input> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Input.class);
        Input question = questionList.get(1);
    }

    @Test
    public void incorrectParent() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_INPUT +
                "   }}";

        AST ast = createAst(content);
        List<Input> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Input.class);
        Input question = questionList.get(1);

    }


}
