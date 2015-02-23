package edu.parser;

import edu.parser.antlrGenerated.QLLexer;
import edu.parser.antlrGenerated.QLParser;
import edu.parser.antlrGenerated.QLVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class AntlrParser {

    public <T> T walk(String inputFilePath, QLVisitor visitor, Class<T> returnClass) throws IOException {
        ANTLRFileStream antlrFileStream = new ANTLRFileStream(inputFilePath);
        QLLexer lexer = new QLLexer(antlrFileStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(commonTokenStream);
        QLParser.FormContext tree = parser.form();

        Object visit = visitor.visit(tree);
        return returnClass.cast(visit);
    }
}
