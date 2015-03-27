package nl.uva.bromance.ast;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionASTTest extends ASTTest {
    @Test
    public void question() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_QUESTION +
                "    }}";

        AST ast = createAst(content);
        List<Question> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Question.class);
        Question question = questionList.get(0);

        assertThat(questionList).hasSize(1);
        assertThat(question.getQuestionString()).isEqualTo("text");
    }


    @Test
    public void formContainsMultipleQuestions() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_QUESTION +
                CORRECT_QUESTION +
                "    }}";

        AST ast = createAst(content);
        List<Question> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Question.class);

        assertThat(questionList).hasSize(2);
    }
}
