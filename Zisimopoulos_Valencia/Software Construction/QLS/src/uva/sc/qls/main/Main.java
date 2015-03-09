package uva.sc.qls.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRFileStream;

import uva.sc.qls.ast.INode;
import uva.sc.qls.parser.*;

public class Main {
    public static void main(String[] args) throws Exception {
    										 
        //CharStream in = new ANTLRFileStream("C:/Users/Pantelis/git/software-construction/QL/form/test.grammar");
        CharStream in = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL_QLS/QLS/form/test.grammar");
        QLSGrammarLexer lexer = new QLSGrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLSGrammarParser parser = new QLSGrammarParser(tokens);
        ParseTree tree = parser.stylesheet();
        
        QLSVisitor visitor = new QLSVisitor();
        INode questionare = visitor.visit(tree);
        System.out.print(questionare);
    }
}
