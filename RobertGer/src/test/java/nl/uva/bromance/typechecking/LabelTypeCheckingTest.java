package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.Label;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class LabelTypeCheckingTest extends ASTTest {

    private static final String CORRECT_LABEL = "Label: \"identifier\"{ Text: \"something\"}";

    @Test
    public void correctLabel() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_LABEL +
                "    }}";

        AST ast = createAst(content);
        List<Label> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Label.class);
        Label question = questionList.get(1);
    }

    @Test
    public void malformedLabel() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "Label: \"identifier\"{ Text: \"something\"" +
                "    }}";

        AST ast = createAst(content);
        List<Label> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Label.class);
        Label question = questionList.get(1);
    }

    @Test
    public void labelWithoutIdentifier() throws IOException {

        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "Label: { Text: \"something\"" +
                "    }}";


        AST ast = createAst(content);
        List<Label> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Label.class);
        Label question = questionList.get(1);
    }
}
