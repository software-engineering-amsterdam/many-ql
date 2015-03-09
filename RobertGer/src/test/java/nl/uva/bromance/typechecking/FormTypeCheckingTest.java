package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.Form;
import nl.uva.bromance.ast.Node;
import org.junit.Test;

import java.io.IOException;


public class FormTypeCheckingTest extends ASTTest {

    @Test
    public void correctForm() throws IOException {
        AST ast = createAst(CORRECT_FORM_SETUP);
        Node root = ast.getRoot();

        NodeAssert.assertThat(root).hasChildrenOfType(Form.class);
        NodeAssert.assertThat(root).hasExactlyChildrenOfType(1, Form.class);
    }
}
