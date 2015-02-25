package cons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.ql.ast.visitor.prettyprinter.PrettyPrinter;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

public class FormCreator {
	private static Parser formParser = new Parser();
	private static PrettyPrinter prettyPrinter = new PrettyPrinter();
	
	/**
	 * The main method, which gets executed once this class is run. Enabled the user
	 * to enter a string, which is then parsed and shown as an AST.
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press 'x' to stop");
			System.out.println("Type 'file:<path>' to load a file from the forms folder.");
			while (true) {
				System.out.print("Enter a statement:");
				String str = br.readLine();
				if ("x".equalsIgnoreCase(str)) {
					System.out.println("Stopped.");
					break;
				}
				else if (str.startsWith("file:")) {
					String path = str.replaceFirst("file:", "");
					System.out.println("Loading from: " + path);
					
					try {
						System.out.println("Not implemented, lol.");
					}
					catch (Exception e) {
						System.out.println("An error has occured:");
						System.err.println(e);
					}
				}
				else {
					ASTNode tree = formParser.parse(str);
					TypeEnvironment register = new TypeEnvironment();
					
					if(!TypeChecker.check(tree, register)) {
						System.out.println("Type error detected in the form.");
						continue;
					}
					
					tree.accept(prettyPrinter);
					
					Evaluator evaluator = new Evaluator();
					
					System.out.println(tree.accept(evaluator));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
