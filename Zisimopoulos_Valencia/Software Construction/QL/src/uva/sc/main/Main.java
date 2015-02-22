package uva.sc.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.ANTLRFileStream;
import uva.sc.logic.Node;
import uva.sc.parser.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream in = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL/form/test.grammar");
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.form();
        
        /*String[] arg0 = { "-visitor", "/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL/src/uva/sc/parser/Grammar.g4", "-package", "uva.sc.parser" };
        org.antlr.v4.Tool.main(arg0);*/
        EvalVisitor visitor = new EvalVisitor();
        Node questionare = visitor.visit(tree);
        System.out.print(questionare);
        
    }
}
