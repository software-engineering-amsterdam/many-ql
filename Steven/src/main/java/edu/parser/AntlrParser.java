package edu.parser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.io.IOException;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class AntlrParser {

    public <T> T parse(String inputFilePath, ParseTreeVisitor visitor, Class<T> returnClass) throws IOException {
        ANTLRFileStream antlrFileStream = new ANTLRFileStream(inputFilePath);
        Lexer lexer = getLexer(antlrFileStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        Parser parser = getParser(commonTokenStream);
        Object visit = visitor.visit(getParseTree(parser));
        return returnClass.cast(visit);
    }

    protected abstract Lexer getLexer(ANTLRFileStream antlrFileStream);

    protected abstract Parser getParser(CommonTokenStream commonTokenStream);

    protected abstract ParseTree getParseTree(Parser parser);
}
