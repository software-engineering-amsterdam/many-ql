package qls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ql.ast.QLNode;
import ql.ast.visitor.prettyprinter.printer.ConsolePrinter;
import ql.errorhandling.ErrorEnvironment;
import qls.ast.visitor.prettyprinter.PrettyPrinter;
import qls.ast.visitor.typechecker.TypeChecker;
import qls.ast.Statement;
import qls.parser.Parser;

public class CommandLine {
	/**
	 * The main method, which gets executed once this class is run. Enabled the user
	 * to enter a string, which is then parsed and shown as an AST.
	 */
	public static void main(String[] args) {
		ErrorEnvironment errorEnvironment = new ErrorEnvironment();
		
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
					QLNode tree = Parser.parse(str);
					
					if(tree instanceof Statement) {
						errorEnvironment = TypeChecker.check((Statement) tree, null); 
						PrettyPrinter.print((Statement) tree, new ConsolePrinter());
					}
					
					if(errorEnvironment.hasErrors()) {
						System.out.println(errorEnvironment.getErrors());
						continue;
					}
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}