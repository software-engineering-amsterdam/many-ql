package nl.uva.bromance;

import org.junit.Test;
import org.antlr.v4.runtime.*;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testApp() throws IOException
    {

            ANTLRInputStream ais = new ANTLRInputStream(getClass().getResourceAsStream("test.ql"));
            nl.uva.bromance.parsers.ExpLexer l = new nl.uva.bromance.parsers.ExpLexer(ais);
            nl.uva.bromance.parsers.ExpParser p = new nl.uva.bromance.parsers.ExpParser(new CommonTokenStream(l));
            p.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
                }
            });
            p.field();

    }
}
