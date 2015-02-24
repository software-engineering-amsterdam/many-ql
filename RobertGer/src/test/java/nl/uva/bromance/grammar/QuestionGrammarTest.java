package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */
public class QuestionGrammarTest {

    private FakeGrammarListener listener;
    private ParseTreeWalker walker;

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }

    @Test
    public void question() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "           Answer: integer" +
                "    }}}";

        walker.walk(listener, createTree(content));

        assertThat(listener.questionCount).isEqualTo(1);
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void questionWithoutText() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Answer: integer" +
                "       }" +
                "    }}";

        walker.walk(listener, createTree(content));
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void questionWithoutAnswerType() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "    }}}";

        walker.walk(listener, createTree(content));
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void malformedQuestion() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "    }}";

        walker.walk(listener, createTree(content));
    }

    @Test(expected = GrammarErrorListener.SyntaxError.class)
    public void questionWithoutIdentifier() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: {" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "           Answer: integer" +
                "       }" +
                "    }}";

        walker.walk(listener, createTree(content));
    }

    @Test
    public void formContainsMultipleQuestions() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Question: \"question\"{" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "           Answer: integer" +
                "       }" +
                "\n     Question: \"question\"{" +
                "           Text: \"How much money did you earn through employer paid wages during 2014?\"" +
                "           Answer: integer" +
                "       }" +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.questionCount).isEqualTo(2);
    }

    private static QLParser.QuestionnaireContext createTree(String content) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(new ByteArrayInputStream(content.getBytes())));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new GrammarErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new GrammarErrorListener());
        return parser.questionnaire();
    }


    static class FakeGrammarListener extends QLParseTreeListener {
        public int questionCount = 0;
        public int questionTextCount = 0;

        @Override
        public void exitQuestion(QLParser.QuestionContext qtx) {
            super.exitQuestion(qtx);
            questionCount += 1;
        }


        @Override
        public void enterQuestionText(QLParser.QuestionTextContext ctx) {
            super.enterQuestionText(ctx);
            this.questionTextCount += 1;
        }
    }
}
