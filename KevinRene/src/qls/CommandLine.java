package qls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.prettyprinter.PrettyPrinter;
import qls.ast.QLSStatement;
import qls.parser.Parser;

public class CommandLine {
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
				else {
					QLNode tree = formParser.parse(str);
					
					if(tree instanceof QLSStatement) {						
						((Statement) tree).accept(prettyPrinter);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
