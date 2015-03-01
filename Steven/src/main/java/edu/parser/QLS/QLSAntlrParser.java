package edu.parser.QLS;

import edu.parser.AntlrParser;
import edu.parser.QLS.antlrGenerated.QLSLexer;
import edu.parser.QLS.antlrGenerated.QLSParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class QLSAntlrParser extends AntlrParser {

    @Override
    protected Lexer getLexer(ANTLRFileStream antlrFileStream) {
        return new QLSLexer(antlrFileStream);
    }

    @Override
    protected QLSParser getParser(CommonTokenStream commonTokenStream) {
        return new QLSParser(commonTokenStream);
    }

    @Override
    protected ParseTree getParseTree(org.antlr.v4.runtime.Parser parser) {
        QLSParser qlParser = (QLSParser) parser;
        return qlParser.stylesheet();
    }
}
