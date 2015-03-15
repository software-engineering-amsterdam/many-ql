package ql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.prettyprinter.PrettyPrinter;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.parser.Parser;

public class CommandLine {
	/**
	 * The main method, which gets executed once this class is run. Enabled the user
	 * to enter a string, which is then parsed and shown as an AST.
	 */
	public static void main(String[] args) {
		TypeEnvironment register = new TypeEnvironment();
		ValueEnvironment valueEnv = new ValueEnvironment();
		
		boolean correctTypes = false;
		Value evaluatorResult = null;
		
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
				else {
					QLNode tree = Parser.parse(str);
					
					if(tree instanceof Statement) {
						correctTypes = TypeChecker.check((Statement) tree, register);
						evaluatorResult = Evaluator.check((Statement) tree, valueEnv);
						
						PrettyPrinter.print((Statement) tree);
					} else {
						correctTypes = TypeChecker.check((Expression) tree, register);
						evaluatorResult = Evaluator.check((Expression) tree, valueEnv);
						
						PrettyPrinter.print((Expression) tree);
					}
					
					if(!correctTypes) {
						System.out.println("Type error detected in the form.");
						continue;
					}
					
					System.out.println(evaluatorResult);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
