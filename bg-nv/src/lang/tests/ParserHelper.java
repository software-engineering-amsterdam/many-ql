package lang.tests;

import lang.ql.ast.AstNode;
import lang.ql.gen.QLLexer;
import lang.ql.gen.QLParser;
import lang.ql.syntax.QLVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by bore on 17/02/15.
 */
public class ParserHelper
{
    public static AstNode ParseExpression(String input)
    {
        QLParser parser = createInputStreamParser(input);
        QLParser.ExpressionContext c = parser.expression();
        QLVisitorImpl visitor = new QLVisitorImpl();

        return visitor.visitExpression(c);
    }

    private static QLParser createInputStreamParser(String input)
    {
        CharStream stream = new ANTLRInputStream(input);
        return createParser(stream);
    }

    private static QLParser createParser(CharStream stream)
    {
        QLLexer lexer = new QLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);
    }
}
