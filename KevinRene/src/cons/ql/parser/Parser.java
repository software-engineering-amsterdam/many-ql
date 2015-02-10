package cons.ql.parser;

import java.io.*;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Binary;
import cons.ql.ast.Form;
import cons.ql.ast.expr.statement.Block;
import cons.ql.ast.expr.statement.Question;

public class Parser {
	
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
					printASTTree(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
	
	public static ASTNode parse (String input) {
		Reader reader = new StringReader(input);
		QLLexer lexer = new QLLexer(reader);
		QLParser parser = new QLParser(lexer);

		lexer.nextToken();
		parser.parse();
		
		return parser.getResult();
	}
	
	/**
	 * Prints the AST tree from a given input string
	 * @param input
	 */
	public static void printASTTree (String input) {
		printSubTree(parse(input), "", true);
	}
	
	/**
	 * Prints a subtree, where a subtree consists of a root node and possibly children
	 * @param root
	 * @param prefix The string that leads up the the current print, includes whitespace and
	 * 					possibly branches. For the actual root this is ""
	 * @param tail Whether or not the current root node is the final child
	 */
	private static void printSubTree(ASTNode root, String prefix, boolean tail) {
		
		if (root == null) {
			System.out.println("This node is undefined");
			return;
		}

		String type = root.getClass().getSimpleName();
		System.out.println(prefix + (tail ? "└── " : "├── ") + root + " : " + type);
		
		// TODO: find a way to get rid of instanceof, perhaps keep a list of children?
		if (root instanceof Binary) {
			printSubTree(((Binary)root).getLeft(), prefix + (tail ? "  " : "│  "), false);
			printSubTree(((Binary)root).getRight(), prefix + (tail ? "  " : "│  "), true);
		}
		else if (root instanceof Question) {
			printSubTree(((Question)root).getIdent(), prefix + (tail ? "  " : "│  "), false);
			printSubTree(((Question)root).getType(), prefix + (tail ? "  " : "│  "), false);
			printSubTree(((Question)root).getText(), prefix + (tail ? "  " : "│  "), true);
		}
		else if (root instanceof Block) {
			int len = ((Block)root).statements().size();
			for (int i = 0; i < len - 1; i++) {
				printSubTree(((Block)root).statements().get(i), prefix + (tail ? "  " : "│  "), false);
			}
			if (len > 0) {
				printSubTree(((Block)root).statements().get(len - 1), prefix + (tail ? "  " : "│  "), true);				
			}
		}
		else if (root instanceof Form) {
			Form form = (Form)root;
			printSubTree(form.getIdent(), prefix + (tail ? "  " : "│  "), false);
			printSubTree(form.getBlock(), prefix + (tail ? "  " : "│  "), true);
		}
	}
}
