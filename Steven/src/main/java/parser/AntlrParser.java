package parser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.antlrGenerated.QLLexer;
import parser.antlrGenerated.QLParser;
import parser.antlrGenerated.QLVisitor;

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
