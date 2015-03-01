package edu.parser.QL;

import edu.parser.AntlrParser;
import edu.parser.QL.antlrGenerated.QLLexer;
import edu.parser.QL.antlrGenerated.QLParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class QLAntlrParser extends AntlrParser {

    @Override
    protected Lexer getLexer(ANTLRFileStream antlrFileStream) {
        return new QLLexer(antlrFileStream);
    }

    @Override
    protected QLParser getParser(CommonTokenStream commonTokenStream) {
        return new QLParser(commonTokenStream);
    }

    @Override
    protected ParseTree getParseTree(org.antlr.v4.runtime.Parser parser) {
        QLParser qlParser = (QLParser) parser;
        return qlParser.form();
    }
}
