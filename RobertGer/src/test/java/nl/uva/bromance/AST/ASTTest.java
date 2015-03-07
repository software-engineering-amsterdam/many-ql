package nl.uva.bromance.AST;

import nl.uva.bromance.ParsingTest;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Robert on 3/1/2015.
 */
public class ASTTest extends ParsingTest {


    protected AST createAst(String content) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(new ByteArrayInputStream(content.getBytes())));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParseTreeListener listener = new QLParseTreeListener();

        new ParseTreeWalker().walk(listener, new QLParser(tokens).questionnaire());

        return listener.getAst();
    }

}
