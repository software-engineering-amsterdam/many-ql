package cons.ql.parser;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


import cons.ql.ast.ASTNode;
import cons.ql.ast.Binary;

public class Test {
	
//	static Reader readFile( String file ) throws IOException {
//	    return new BufferedReader(new FileReader (file));
//	}
	
	public static void main(String [] args) throws IOException {
//		Reader reader = readFile("input.txt");
		
//		System.out.println("Starting test");
		
		printASTTree("5 + 5 - 10 * 193");
	}
	
	public static ASTNode testString (String input) {
		Reader reader = new StringReader(input);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		parser.parse();
//		System.out.println("Parser success: " + parser.parse());
//		System.out.println(parser.getResult());
		
		return parser.getResult();
	}
	
	public static void printASTTree (String input) {
		ASTNode root = testString(input);
		
		printSubTree(root, "", true);
	}
	
	private static void printSubTree(ASTNode root, String prefix, boolean tail) {

		System.out.println(prefix + (tail ? "└── " : "├── ") + root);
		
		if (root instanceof Binary) {
			printSubTree(((Binary)root).getLeft(), prefix + (tail ? "  " : "│  "), false);
			printSubTree(((Binary)root).getRight(), prefix + (tail ? "  " : "│  "), true);
		}
	}
}
