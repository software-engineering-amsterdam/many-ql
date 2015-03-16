package ql.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

import ql.ast.QLNode;

public class Parser {
	/**
	 * Same as {@link #parse(String) parse()} but takes the path to a file and parses
	 * the contents of that file.
	 * @param filepath
	 * @return
	 */
	public static QLNode parseFile (String filepath) {
		try {
			Reader reader = new BufferedReader(new FileReader(filepath));
			QLLexer lexer = new QLLexer(reader);
			QLParser parser = new QLParser(lexer);
	
			lexer.nextToken();
			parser.parse();
			
			return parser.getResult();
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	/**
	 * Parses the input string and returns the result, which is the root Node of the AST.
	 * @param input The string to parse
	 * @return ASTNode of the root
	 */
	public static QLNode parse (String input) {
		Reader reader = new StringReader(input);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		parser.parse();
		
		return parser.getResult();
	}
}
