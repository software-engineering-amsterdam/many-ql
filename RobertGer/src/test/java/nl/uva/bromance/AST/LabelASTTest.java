package nl.uva.bromance.ast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LabelASTTest extends ASTTest {

    private static final String CORRECT_LABEL = "Label: \"identifier\"{ Text: \"something\"}";

    @Test
    public void correctLabel() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_LABEL +
                "    }}";

        AST ast = createAst(content);
        List<Label> labelList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Label.class);

        assertThat(labelList).hasSize(1);

        Label label = labelList.get(0);
        assertThat(label.hasChildren()).isTrue();
    }
}
