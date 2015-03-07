package nl.uva.bromance.AST;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Robert on 3/2/2015.
 */
public class FormASTTest extends ASTTest {

    @Test
    public void correctForm() throws IOException {
        AST ast = createAst(CORRECT_FORM_SETUP);
        Node root = ast.getRoot();

        NodeAssert.assertThat(root).hasChildrenOfType(Form.class);
        NodeAssert.assertThat(root).hasExactlyChildrenOfType(1, Form.class);
    }
}
