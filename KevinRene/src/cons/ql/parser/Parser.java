package cons.ql.parser;

import java.io.*;

import cons.ql.ast.ASTNode;
import cons.ql.ast.Binary;
import cons.ql.ast.Form;
import cons.ql.ast.expr.statement.Assignment;
import cons.ql.ast.expr.statement.Block;
import cons.ql.ast.expr.statement.Question;

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
					printASTTree(str);
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
	private static void printSubTree(ASTNode root, String prefix, boolean isTail) {
		
		if (root == null) {
			System.out.println("This node is undefined");
			return;
		}

		String type = root.getClass().getSimpleName();
		System.out.println(prefix + (isTail ? "└── " : "├── ") + root + " : " + type);
		
		prefix += (isTail ? "  " : "│  ");
		
		// TODO: find a way to get rid of instanceof, perhaps keep a list of children?
		if (root instanceof Binary) {
			Binary binary = (Binary)root;
			
			printSubTree(binary.getLeft(), prefix, false);
			printSubTree(binary.getRight(), prefix, true);
		}
		else if (root instanceof Assignment) {
			Assignment assignment = (Assignment)root;
			
			printSubTree(assignment.getIdent(), prefix, false);
			printSubTree(assignment.getType(), prefix, false);
			printSubTree(assignment.getText(), prefix, false);
			printSubTree(assignment.getExpr(), prefix, true);
		}
		else if (root instanceof Question) {
			Question question = (Question)root;
			
			printSubTree(question.getIdent(), prefix, false);
			printSubTree(question.getType(), prefix, false);
			printSubTree(question.getText(), prefix, true);
		}
		else if (root instanceof Block) {
			Block block = (Block)root;
			
			// First print the children except for the last one due to different
			// tail values. The last one should have a tail.
			int len = block.statements().size();
			for (int i = 0; i < len - 1; i++) {
				printSubTree(block.statements().get(i), prefix, false);
			}
			if (len > 0) {
				printSubTree(block.statements().get(len - 1), prefix, true);				
			}
		}
		else if (root instanceof Form) {
			Form form = (Form)root;
			printSubTree(form.getIdent(), prefix, false);
			printSubTree(form.getBlock(), prefix, true);
		}
	}
}
