package ql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.QLType;
import ql.ast.Statement;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.ast.visitor.prettyprinter.PrettyPrinter;
import ql.ast.visitor.prettyprinter.printer.ConsolePrinter;
import ql.ast.visitor.typechecker.TypeChecker;
import ql.ast.visitor.typechecker.TypeEnvironment;
import ql.errorhandling.ErrorEnvironment;
import ql.parser.Parser;

public class CommandLine {
	/**
	 * The main method, which gets executed once this class is run. Enabled the user
	 * to enter a string, which is then parsed and shown as an AST.
	 */
	public static void main(String[] args) {
		TypeEnvironment register = new TypeEnvironment();
		ValueEnvironment valueEnv = new ValueEnvironment();
		ErrorEnvironment errorEnvironment;
		
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
						errorEnvironment = TypeChecker.check((Statement) tree, register);
						evaluatorResult = Evaluator.check((Statement) tree, valueEnv);
						
						PrettyPrinter.print((Statement) tree, new ConsolePrinter(), PrettyPrinter.DEFAULT_PREFIX);
					} else if(tree instanceof Expression) {
						errorEnvironment = TypeChecker.check((Expression) tree, register);
						evaluatorResult = Evaluator.check((Expression) tree, valueEnv);
						
						PrettyPrinter.print((Expression) tree, new ConsolePrinter(), PrettyPrinter.DEFAULT_PREFIX);
					} else {
						errorEnvironment = TypeChecker.check((QLType) tree, register);
						PrettyPrinter.print((QLType) tree, new ConsolePrinter(), PrettyPrinter.DEFAULT_PREFIX);
					}					
					
					if(errorEnvironment.hasErrors()) {
						System.out.println(errorEnvironment.getErrors());
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
