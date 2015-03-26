package nl.uva.bromance.typechecking;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.ASTTest;
import nl.uva.bromance.ast.Question;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTypeCheckingTest extends ASTTest {
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
    public void questionWithoutText() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Answer: integer" +
                "       }" +
                "    }}";

        AST ast = createAst(content);
        List<Question> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Question.class);
        Question question = questionList.get(1);

        assertThat(questionList).hasSize(1);
        assertThat(question.getIdentifier()).isNotNull();
        assertThat(question.getQuestionString()).isEqualTo("something");
    }

    @Test
    public void questionWithoutAnswerType() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "    }}}";

        AST ast = createAst(content);
        List<Question> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Question.class);
        Question question = questionList.get(1);

        assertThat(questionList).hasSize(1);
        assertThat(question.getIdentifier()).isNotNull();
        assertThat(question.getQuestionString()).isEqualTo("something");
    }

    @Test
    public void malformedQuestion() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "    }}";

        AST ast = createAst(content);
        List<Question> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Question.class);
        Question question = questionList.get(1);

        assertThat(questionList).hasSize(1);
        assertThat(question.getIdentifier()).isNotNull();
        assertThat(question.getQuestionString()).isEqualTo("something");
    }

    @Test
    public void questionWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: {" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "           Answer: integer" +
                "       }" +
                "    }}";

        AST ast = createAst(content);
        List<Question> questionList = ast.getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Question.class);
        Question question = questionList.get(1);

        assertThat(questionList).hasSize(1);
        assertThat(question.getIdentifier()).isNotNull();
        assertThat(question.getQuestionString()).isEqualTo("something");
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
        Question question = questionList.get(1);

        assertThat(questionList).hasSize(1);
        assertThat(question.getIdentifier()).isNotNull();
    }
}
