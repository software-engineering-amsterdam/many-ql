package ql.ast.visitor.prettyprinter.printer;

import ql.ast.visitor.prettyprinter.PrintWriter;

public class WriterCache implements PrintWriter {
	private String cachedString;
	
	public WriterCache() {
		cachedString = "";
	}
	
	public String getCachedString() {
		return cachedString;
	}
	
	@Override
	public void printString(String output) {
		cachedString = output;
	}
}
