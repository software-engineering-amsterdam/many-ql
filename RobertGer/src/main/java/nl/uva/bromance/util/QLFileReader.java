package nl.uva.bromance.util;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.conditionals.ExpressionEvaluator;
import nl.uva.bromance.ast.visitors.ConditionalHandler;
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

    public static AST<QLNode> readFile(String qlPath) throws IOException {

        QLLexer lexer = new QLLexer(new ANTLRFileStream(qlPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new GrammarErrorListener());

        ParseTree tree = parser.questionnaire();
        QLParseTreeListener listener = new QLParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        AST<QLNode> qlAst = listener.getAst();

        //TODO:Evaluator and Handler need to be executed in this order. Maybe we want to force that.
        new ExpressionEvaluator().evaluate(qlAst.getRoot());
        new ConditionalHandler().handle(qlAst.getRoot());

        return qlAst;
    }

}
