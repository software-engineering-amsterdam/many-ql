package lang.tests;

import lang.ql.gen.QLLexer;
import lang.ql.gen.QLParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nik on 10-2-15.
 */
public class ParserTest
{
    private int max = Integer.MAX_VALUE;
    private int min = 0;

    private int maxDepth = 10;
    private int minDepth = 1;

    private Random random;

    @Test
    public void execute()
    {
        System.out.println("Entering ParserTest");

        // unary equality
        this.testExpression("+-");

        this.testExpression("+-2", "(expression + (expression - (expression 2)))");
        // unary over multiplication/division/modulo
        this.testExpression("1*-2", "(expression (expression 1) * (expression - (expression 2)))");
        this.testExpression("1/-2", "(expression (expression 1) / (expression - (expression 2)))");
        this.testExpression("1%-2", "(expression (expression 1) % (expression - (expression 2)))");

        // multiplication/division/modulo equality
        this.testExpression("1*2/3%4", "(expression (expression (expression (expression 1) * (expression 2)) / (expression 3)) % (expression 4))");
        this.testExpression("1%2*3/4", "(expression (expression (expression (expression 1) % (expression 2)) * (expression 3)) / (expression 4))");
        // multiplication/division/modulo over addition/subtraction
        this.testExpression("1*2-3", "(expression (expression (expression 1) * (expression 2)) - (expression 3))");
        this.testExpression("1+2*3", "(expression (expression 1) + (expression (expression 2) * (expression 3)))");
        this.testExpression("1%2-3*4", "(expression (expression (expression 1) % (expression 2)) - (expression (expression 3) * (expression 4)))");

        // addition/subtraction equality
        this.testExpression("1+2-3+4", "(expression (expression (expression (expression 1) + (expression 2)) - (expression 3)) + (expression 4))");
        // addition/subtraction over >, <, <=, >=
        this.testExpression("1-2<3", "(expression (expression (expression 1) - (expression 2)) < (expression 3))");
        this.testExpression("1>=2+3", "(expression (expression 1) >= (expression (expression 2) + (expression 3)))");
        this.testExpression("1+2>3-4", "(expression (expression (expression 1) + (expression 2)) > (expression (expression 3) - (expression 4)))");

        // >, <, <=, >= equality
        this.testExpression("1<2>3>=4<=5", "(expression (expression (expression (expression (expression 1) < (expression 2)) > (expression 3)) >= (expression 4)) <= (expression 5))");
        this.testExpression("1>=2<3<=4>5", "(expression (expression (expression (expression (expression 1) >= (expression 2)) < (expression 3)) <= (expression 4)) > (expression 5))");
        // >, <, <=, >= over ==, !=
        this.testExpression("1<2==3", "(expression (expression (expression 1) < (expression 2)) == (expression 3))");
        this.testExpression("1!=2>=3", "(expression (expression 1) != (expression (expression 2) >= (expression 3)))");
        this.testExpression("1>2==3<=4", "(expression (expression (expression 1) > (expression 2)) == (expression (expression 3) <= (expression 4)))");

        // ==, != equality
        this.testExpression("1==2!=3==4", "(expression (expression (expression (expression 1) == (expression 2)) != (expression 3)) == (expression 4))");
        // ==, != over &&
        this.testExpression("1&&2==3", "(expression (expression 1) && (expression (expression 2) == (expression 3)))");
        this.testExpression("1==2&&3!=4", "(expression (expression (expression 1) == (expression 2)) && (expression (expression 3) != (expression 4)))");

        // && over ||
        this.testExpression("1&&2||3&&4", "(expression (expression (expression 1) && (expression 2)) || (expression (expression 3) && (expression 4)))");

        System.out.println("Exiting ParserTest");
    }

    private void testExpression(String input)
    {
        QLParser parser = createInputStreamParser(input);
        parser.expression();
        assertTrue(parser.getNumberOfSyntaxErrors() > 0);
    }

    private void testExpression(String input, String compareString)
    {
        QLParser parser = createInputStreamParser(input);
        ParseTree tree = parser.expression();
        String result = tree.toStringTree(parser);
        assertEquals(compareString, result);
    }

    private QLParser createInputStreamParser(String input)
    {
        CharStream stream = new ANTLRInputStream(input);
        return createParser(stream);
    }

    private QLParser createFileStreamParser(String filePath) throws IOException
    {
        CharStream stream = new ANTLRFileStream(filePath);
        return createParser(stream);
    }

    private QLParser createParser(CharStream stream)
    {
        QLLexer lexer = new QLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLParser(tokens);
    }
}