package com.antlr4.zarina.tazql;

public class TestWalker extends TaZQLBaseListener {
	public void enter(TaZQLParser.RContext context) {
		System.out.println("Entering:" +context.ID().getText());	
	}
	
	public void exit(TaZQLParser.RContext context) {
		System.out.println("Exiting");
	}
}

