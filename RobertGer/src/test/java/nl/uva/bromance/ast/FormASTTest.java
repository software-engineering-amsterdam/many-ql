package nl.uva.bromance.ast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FormASTTest extends ASTTest {

    @Test
    public void correctForm() throws IOException {
        AST<QLNode> ast = createAst(CORRECT_FORM_SETUP);
        QLNode root = ast.getRoot();

        NodeAssert.assertThat(root).hasChildrenOfType(Form.class);
        NodeAssert.assertThat(root).hasExactlyChildrenOfType(1, Form.class);
    }

    @Test
    public void multipleForms() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                CORRECT_FORM +
                CORRECT_FORM +
                "}";

        AST ast = createAst(content);
        List<Form> formList = ast.getAllChildrenOfType_ForAst(Form.class);

        assertThat(formList).hasSize(2);
    }
}
