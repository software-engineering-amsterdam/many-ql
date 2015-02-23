package cons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.prettyprinter.PrettyPrinter;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

public class FormCreator {
	private static Parser formParser = new Parser();
	private static TypeChecker typeChecker = new TypeChecker();
	private static PrettyPrinter prettyPrinter = new PrettyPrinter();
	
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
					ASTNode tree = formParser.parse(str);
					
					if(!typeChecker.check(tree)) {
						System.out.println("Type error detected in the form.");
						return;
					}
					
					tree.accept(prettyPrinter);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
