import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fugazi.checker.EvalVisitor;

import java.io.FileInputStream;
import java.io.InputStream;

import org.fugazi.checker.EvalVisitor;
import org.fugazi.parser.LabeledExprLexer;
import org.fugazi.parser.LabeledExprParser;

public class Calc {
    
    public static void main(String[] args) throws Exception {
        
        String inputFile = null;
        if (args.length > 0) 
            inputFile = args[0];
        
        InputStream is = System.in;
        
        if (inputFile != null) 
            is = new FileInputStream(inputFile);
        
        // The input streamer.
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        // The lexer with the input.
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        
        // The Tokens stream using the lexer.
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // The parser using the tokens.
        LabeledExprParser parser = new LabeledExprParser(tokens);
        
        // Parse tree on prog expression.
        ParseTree tree = parser.prog(); // parse

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
