package nl.uva.bromance.parsers;

import nl.uva.bromance.parsers.listeners.QLParseTreeListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 10-2-2015.
 */
public class GrammarTest {
    ParseTree tree;

    @Before
    public void setup() throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("GrammarTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        tree = parser.questionnaire();
    }

    @Test
    public void containsThreeForms() {
        FakeGrammarListener listener = new FakeGrammarListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        assertThat(listener.formCount).isEqualTo(5);
    }

    @Test
    public void containsThreeQuestions() {
        FakeGrammarListener listener = new FakeGrammarListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        assertThat(listener.questionCount).isEqualTo(7);
    }

    static class FakeGrammarListener extends QLParseTreeListener {
        public int formCount = 0;
        public int questionCount = 0;

        @Override
        public void exitForm(QLParser.FormContext ftx) {
            super.exitForm(ftx);
            formCount += 1;
        }

        @Override
        public void exitQuestion(QLParser.QuestionContext qtx) {
            super.exitQuestion(qtx);
            questionCount += 1;
        }
    }


}
