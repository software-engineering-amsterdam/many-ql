package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */
public class IfSequenceTest {

    private FakeGrammarListener listener;
    private ParseTreeWalker walker;

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }

    @org.junit.Test
    public void correctIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                "           Label: something" +
                "{}"+
                "    }}}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
    }


    @org.junit.Test(expected = GrammarErrorListener.SyntaxError.class)
    public void formContainsIfStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
    }

    @org.junit.Test(expected = GrammarErrorListener.SyntaxError.class)
    public void malformedIfStatementBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                "    }}";
        walker.walk(listener, createTree(content));
    }

    @org.junit.Test(expected = GrammarErrorListener.SyntaxError.class)
    public void ifStatementHasNoExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: {}" +
                "    }}";
        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void formContainsMultipleIfStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "\n     If: something{}" +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(2);
    }

    @org.junit.Test(expected = GrammarErrorListener.SyntaxError.class)
    public void elseIfStatementWithoutPrecedingIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Else If: something{}" +
                "    }}";
        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void ifStatementAndElseIfStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "\n     Else If: something{}" +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(1);
    }

    @org.junit.Test
    public void ifStatementAndMultipleElseIfStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "\n     Else If: something{}" +
                "\n     Else If: something{}" +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(2);
    }

    @org.junit.Test
    public void formContainsIfStatementAndElseStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "\n     Else:{}" +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseStatementCount).isEqualTo(1);
    }

    @org.junit.Test(expected = GrammarErrorListener.SyntaxError.class)
    public void formContainsElseStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Else:{}" +
                "    }}";
        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void formContainsIfStatementAndElseIfStatementAndElseStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "\n     Else If: something{}" +
                "\n     Else:{}" +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(1);
        assertThat(listener.elseStatementCount).isEqualTo(1);
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
        public int ifStatementCount = 0;
        public int elseIfStatementCount = 0;
        public int elseStatementCount = 0;

        @Override
        public void exitIfStatement(QLParser.IfStatementContext ctx) {
            super.exitIfStatement(ctx);
            ifStatementCount += 1;
        }

        @Override
        public void exitElseIfStatement(QLParser.ElseIfStatementContext ctx) {
            super.exitElseIfStatement(ctx);
            this.elseIfStatementCount += 1;
        }

        @Override
        public void exitElseStatement(QLParser.ElseStatementContext ctx) {
            super.exitElseStatement(ctx);
            this.elseStatementCount += 1;
        }
    }
}
