import org.antlr.v4.runtime.ANTLRFileStream;

import java.io.IOException;

/**
 * Created by Steven Kok on 3/02/2015.
 */
public class Walker {

    public void walk() throws IOException {
        ANTLRFileStream antlrFileStream = new ANTLRFileStream("antlr/input/QL_initial");
        QLLexer qlLexer = new QLLexer(antlrFileStream);
    }
}
