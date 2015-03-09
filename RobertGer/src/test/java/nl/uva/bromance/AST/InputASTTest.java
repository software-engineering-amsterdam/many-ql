package nl.uva.bromance.ast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputASTTest extends ASTTest {

    private static final String CORRECT_INPUT = "Input: expression";

    @Test
    public void correctInput() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                CORRECT_INPUT +
                "   }}}";

        AST ast = createAst(content);
        List<Input> inputList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Input.class);
        Input input = inputList.get(0);

        assertThat(input.hasChildren()).isTrue();
    }
}
