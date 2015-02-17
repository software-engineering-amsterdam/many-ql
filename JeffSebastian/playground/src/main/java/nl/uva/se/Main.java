package nl.uva.se;

import java.io.IOException;

import nl.uva.se.ast.Node;
import nl.uva.se.interpreter.Interpreter;
import nl.uva.se.interpreter.SymbolTable;
import nl.uva.se.parser.QLLexer;
import nl.uva.se.parser.QLParser;
import nl.uva.se.parser.QLVisitorImpl;
import nl.uva.se.visitor.SimpleVisitor;
import nl.uva.se.visitor.Visitor;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

	public static void main(String[] args) {
		try {
			ANTLRFileStream reader = new ANTLRFileStream("./src/main/resources/example.txt");
			QLLexer lexer = new QLLexer(reader);
			TokenStream tokens = new CommonTokenStream(lexer);
			QLParser parser = new QLParser(tokens);
			ParseTree tree = parser.form();
			
			QLVisitorImpl visitor = new QLVisitorImpl();
			Node ast = visitor.visit(tree);
			
			Interpreter interpreter = new Interpreter();
			ast.accept(interpreter);
			System.out.println(SymbolTable.getInstance());
			
			Visitor myVisitor = new SimpleVisitor();
			ast.accept(myVisitor);
			
			// Symbol Table
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
