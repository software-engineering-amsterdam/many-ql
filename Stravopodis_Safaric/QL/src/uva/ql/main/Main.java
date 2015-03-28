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

public class Main{
	
	public static void main(String[] args) throws IOException{
		
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
	
	public static ParseTree getParseTree(String path) throws IOException{
		
		ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream(path));
		QLLexer lexer = new QLLexer(inputStream);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(stream);
		ParseTree tree = parser.prog();
		
		return tree;
	}
	
	public static Node getAST(ParseTree tree){
		QLMainVisitor visitor = new QLMainVisitor();
		Node ast = visitor.visit(tree);
		
		return ast;
	}
	
}
