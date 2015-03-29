package nl.uva.bromance.ast;

import nl.uva.bromance.ParsingTest;
import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/*We don't test faulty syntax in the ASTTests
 * */
public class ASTTest extends ParsingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    protected AST<QLNode> createAst(String content) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(new ByteArrayInputStream(content.getBytes())));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParseTreeListener listener = new QLParseTreeListener();

        QLParser qlParser = new QLParser(tokens);
        qlParser.removeErrorListeners();
        qlParser.addErrorListener(new GrammarErrorListener());

        new ParseTreeWalker().walk(listener, qlParser.questionnaire());

        return listener.getAst();
    }

}
