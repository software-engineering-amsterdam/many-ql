package uva.sc.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRFileStream;

import uva.sc.ast.INode;
import uva.sc.parser.*;
import uva.sc.typeChecker.TypeCheckerVisitor;

public class Main {
    public static void main(String[] args) throws Exception {
    										 
        CharStream in = new ANTLRFileStream("C:/Users/Pantelis/git/software-construction/QL/form/test.grammar");
        //CharStream in = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction//QL/QL/form/test.grammar");
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.form();
        
        //try{
	        QLVisitor visitor = new QLVisitor();
	        INode questionare = visitor.visit(tree);
	        System.out.print(questionare);
	        
	        TypeCheckerVisitor vis = new TypeCheckerVisitor();
	        questionare.accept(vis);
	        System.out.print("\n" + vis.getErrors());
	        System.out.print("\n" + vis.getWarnings());
	        //System.out.println("\n" + vis.getCircularDependencies());
        //}
        //catch(Exception e){
        	//System.out.print(e.toString());
        //}
        
        
    }
}
