package uva.ql.main;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Prog;
import uva.ql.interpreter.gui.GUI;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.TypeCheck;
import uva.ql.interpreter.typecheck.TypeCheckVisitor;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;

public class Main{
	
	public static void main(String[] args) throws IOException{
		
		ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream("SupportingFiles/Test.ql"));
		QLLexer lexer = new QLLexer(inputStream);
		
		CommonTokenStream stream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(stream);
		ParseTree tree = parser.prog();
		
		QLMainVisitor visitor = new QLMainVisitor();
		ASTNode ast = visitor.visit(tree);
		
		
		TypeCheck typeCheck = new TypeCheck(ast);
		typeCheck.getSymbolTable().printSymbolTable();
		
		Subject subject = new Subject();
		
		GUI gui = new GUI(typeCheck.getSymbolTable(), (Prog)ast, subject);
		gui.rander();
	}
}
