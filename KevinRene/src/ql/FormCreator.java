package ql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ql.ast.QLNode;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.prettyprinter.PrettyPrinter;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

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
					QLNode tree = formParser.parse(str);
					TypeEnvironment register = new TypeEnvironment();
					ValueEnvironment valueEnv = new ValueEnvironment();
					
					if(!TypeChecker.check(tree, register)) {
						System.out.println("Type error detected in the form.");
						continue;
					}
					
					tree.accept(prettyPrinter);
					
					System.out.println(Evaluator.check(tree, valueEnv));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
