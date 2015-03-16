package ql.ast.visitor.prettyprinter.printer;

import ql.ast.visitor.prettyprinter.PrintWriter;

public class ConsolePrinter implements PrintWriter {
	@Override
	public void printString(String output) {
		System.out.println(output);
	}
}
