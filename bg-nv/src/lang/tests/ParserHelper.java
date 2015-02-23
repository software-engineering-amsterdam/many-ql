package lang.tests;

import lang.ql.ast.AstNode;
import lang.ql.gen.QLLexer;
import lang.ql.gen.QLParser;
import lang.ql.ast.QLVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/**
 * Created by bore on 17/02/15.
 */
public class ParserHelper
{
    private static final String path = "samples/";

    public static AstNode ParseExpression(String input)
    {
        QLParser parser = createInputStreamParser(input);
        QLParser.ExpressionContext c = parser.expression();
        QLVisitor visitor = new QLVisitor();

        return visitor.visitExpression(c);
    }

    public static AstNode ParseQuestion(String input)
    {
        QLParser parser = createInputStreamParser(input);
        QLParser.QuestionContext c = parser.question();
        QLVisitor visitor = new QLVisitor();

        return visitor.visitQuestion(c);
    }

    public static AstNode ParseIfCondition(String input)
    {
        QLParser parser = createInputStreamParser(input);
        QLParser.IfConditionContext c = parser.ifCondition();
        QLVisitor visitor = new QLVisitor();

        return visitor.visitIfCondition(c);
    }

    public static AstNode ParseForm(String file)
    {
        QLParser parser = createFileStreamParser(file);
        QLParser.FormContext f = parser.form();
        QLVisitor visitor = new QLVisitor();

        return visitor.visitForm(f);
    }

    private static QLParser createInputStreamParser(String input)
    {
        CharStream stream = new ANTLRInputStream(input);
        return createParser(stream);
    }

    private static QLParser createFileStreamParser(String file)
    {
        CharStream stream = null;
        try
        {
            stream = new ANTLRFileStream(path + file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return createParser(stream);
    }

    private static QLParser createParser(CharStream stream)
    {
        QLLexer lexer = new QLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);
    }
}
