package lang.tests;

import lang.ql.gen.QLLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

/**
 * Created by Nik on 10-2-15.
 */
import static org.junit.Assert.assertEquals;

public class LexerTest
{

    public void testLexer()
    {
        System.out.println("Entering LexerTest");

        CharStream inputStream = new ANTLRInputStream("\"2+5\" 2+5 true-5 == false");
        QLLexer lexer = new QLLexer(inputStream);

        String[] strTokens = {"\"2+5\"", " ", "2", "+", "5", " ", "true", "-", "5", " ", "==", " ", "false"};
        int i = 0;
        while (true)
        {
            Token token = lexer.nextToken();
            if (token.getType() == Token.EOF)
            {
                break;
            }
            assertEquals(token.getText(), strTokens[i++]);
        }

        System.out.println("Exiting LexerTest");
    }

}
