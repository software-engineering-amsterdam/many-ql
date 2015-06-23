package uva.ql.main;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.ql.ast.Node;
import uva.ql.ast.Prog;
import uva.ql.interpreter.gui.Renderer;
import uva.ql.interpreter.typecheck.TypeCheckVisitor;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;
import uva.ql.test.Test;

public class Main{
	
	public static void main(String[] args) {
		
		Test test = new Test();
		test.runTestSuite();
		
		ParseTree tree = getParseTree("SupportingFiles/Test.ql");
		Prog prog = (Prog)getAST(tree);
		
		TypeCheckVisitor typeCheck = new TypeCheckVisitor();
		typeCheck.visitProg(prog);
		
		if (!typeCheck.hasErrors()){
			Renderer renderer = new Renderer(prog);
			renderer.visitProg(prog);
		}
		else {
			typeCheck.printIssues();
		}
	}
	
	private static ParseTree getParseTree(String path){
		
		ANTLRInputStream inputStream = null;
		
		try{
			inputStream = new ANTLRInputStream(new FileInputStream(path));
			
		}
		catch (IOException ioException){
			System.out.println("Exception: " + ioException.getMessage());
		}
		
		QLLexer lexer = new QLLexer(inputStream);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(stream);
		ParseTree tree = parser.prog();
		
		return tree;
	}
	
	private static Node getAST(ParseTree tree){
		QLMainVisitor visitor = new QLMainVisitor();
		Node ast = visitor.visit(tree);
		
		return ast;
	}
	
}
