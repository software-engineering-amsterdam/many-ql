package org.uva.sea.ql.parser.jacc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test {
	
	static Reader readFile( String file ) throws IOException {
	    return new BufferedReader(new FileReader (file));
	}
	
	public static void main(String [] args) throws IOException {
		Reader reader = readFile("input.txt");
		QLLexer lexer = new QLLexer(reader);
		
		System.out.println(lexer.getSemantic());
	}
}
