package nl.uva.se;

import java.io.IOException;

import nl.uva.se.parser.QLLexer;
import nl.uva.se.parser.QLParser;
import nl.uva.se.visitor.QLVisitorImpl;

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
			visitor.visit(tree);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
