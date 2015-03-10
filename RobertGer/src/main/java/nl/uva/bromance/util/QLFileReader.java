package nl.uva.bromance.util;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.conditionals.ExpressionEvaluator;
import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by Ger on 9-3-2015.
 */
public class QLFileReader {

    public static AST readFile(String qlPath) throws IOException {

        QLLexer lexer = new QLLexer(new ANTLRFileStream(qlPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new GrammarErrorListener());

        ParseTree tree = parser.questionnaire();
        QLParseTreeListener listener = new QLParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        ExpressionEvaluator.evaluateExpressions(listener.getAst());

        return listener.getAst();
    }

}
