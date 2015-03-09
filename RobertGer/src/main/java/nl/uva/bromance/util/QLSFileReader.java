package nl.uva.bromance.util;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.listeners.QLSParseTreeListener;
import nl.uva.bromance.parsers.QLSLexer;
import nl.uva.bromance.parsers.QLSParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by Ger on 9-3-2015.
 */
public class QLSFileReader {

    public static AST readFile(String qlsPath, AST qlAst) throws IOException {

        QLSLexer qlsLexer = new QLSLexer(new ANTLRFileStream(qlsPath));
        CommonTokenStream qlsTokens = new CommonTokenStream(qlsLexer);
        QLSParser qlsParser = new QLSParser(qlsTokens);
        ParseTree qlsTree = qlsParser.stylesheet();
        QLSParseTreeListener qlsListener = new QLSParseTreeListener(qlAst);

        ParseTreeWalker qlsWalker = new ParseTreeWalker();
        qlsWalker.walk(qlsListener, qlsTree);
        return qlsListener.getAst();
    }

}
