package org.uva.sea.ql.parser.jacc;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.uva.sea.ql.ast.ASTNode;

public class Test {
	
//	static Reader readFile( String file ) throws IOException {
//	    return new BufferedReader(new FileReader (file));
//	}
	
	public static void main(String [] args) throws IOException {
//		Reader reader = readFile("input.txt");
		
		System.out.println("Starting test");
		
		testString("5 + 5 - 10 * 193");
	}
	
	private static ASTNode testString (String input) {
		Reader reader = new StringReader(input);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		System.out.println("Parser success: " + parser.parse());
		System.out.println(parser.getResult());
		
		return parser.getResult();
	}
}
