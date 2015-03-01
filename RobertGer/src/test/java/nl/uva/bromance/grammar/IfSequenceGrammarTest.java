package nl.uva.bromance.grammar;

import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Robert on 2/24/2015.
 */

public class IfSequenceGrammarTest extends GrammarTest {

    public static final String CORRECT_ELSE = "\n     Else:{ Text: \"something\"}";
    public static final String CORRECT_IF = "\n     If: something{  Text: \"something\" }";
    public static final String CORRECT_ELSE_IF = "Else If: something{ Text: \"something\"}";
    private FakeGrammarListener listener;
    private ParseTreeWalker walker;

    @Before
    public void setup() {
        listener = new FakeGrammarListener();
        walker = new ParseTreeWalker();
    }


    //Check if statement
    @org.junit.Test
    public void correctIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "}}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
    }


    @org.junit.Test
    public void ifStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @org.junit.Test
    public void malformedIfStatementBody() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: something{" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void ifStatementHasNoExpression() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     If: { Text: \"something\" }" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void multipleIfStatements() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_IF +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(2);
    }


    //Check else if statement

    @org.junit.Test
    public void correctElseIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(1);
    }

    @org.junit.Test
    public void elseIfStatementWithoutPrecedingIfStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                "\n     Else If: something{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void elseIfWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "\n     Else If: something{}" +
                "    }}";
        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @org.junit.Test
    public void multipleCorrectElseIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                CORRECT_ELSE_IF +
                "    }}";
        walker.walk(listener, createTree(content));

        assertThat(listener.ifStatementCount).isEqualTo(1);
        assertThat(listener.elseIfStatementCount).isEqualTo(2);
    }


    //Check Else Statement

    @org.junit.Test
    public void correctElse() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE +
                "    }}";

        walker.walk(listener, createTree(content));

        assertThat(listener.elseStatementCount).isEqualTo(1);
    }

    @org.junit.Test
    public void elseStatementWithoutBodyContents() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "\n     Else:{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void elseWithoutPrecedingIf() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_ELSE +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));
    }

    @org.junit.Test
    public void elseWithoutBodyContent() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                CORRECT_ELSE_IF +
                "     Else:{}" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    @org.junit.Test
    public void malformedElseStatement() throws IOException {
        String content = "Name: \"Tax\" {\n" +
                "    Form: \"default\" {\n" +
                CORRECT_IF +
                "     Else:{" +
                "    }}";

        expectedException.expect(GrammarErrorListener.SyntaxError.class);

        walker.walk(listener, createTree(content));

    }

    //TODO: Maybe move the entire thing to GrammarTest? Duplication in other tests.
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
