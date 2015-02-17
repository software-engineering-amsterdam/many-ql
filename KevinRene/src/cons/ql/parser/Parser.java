package cons.ql.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.statement.Block;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.statement.Form;
import cons.ql.ast.statement.Question;

public class Parser {
	/**
	 * The main method, which gets executed once this class is run. Enabled the user
	 * to enter a string, which is then parsed and shown as an AST.
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press 'x' to stop");
			while (true) {
				System.out.print("Enter a statement:");
				String str = br.readLine();
				if ("x".equalsIgnoreCase(str)) {
					System.out.println("Stopped.");
					break;
				}
				else {
					//printASTTree(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Same as {@link #parse(String) parse()} but takes the path to a file and parses
	 * the contents of that file.
	 * @param filepath
	 * @return
	 */
	public static ASTNode parseFile (String filepath) {
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
	public static ASTNode parse (String input) {
		Reader reader = new StringReader(input);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		parser.parse();
		
		return parser.getResult();
	}
}
