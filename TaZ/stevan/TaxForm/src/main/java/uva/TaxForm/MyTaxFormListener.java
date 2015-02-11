package uva.TaxForm;

import uva.TaxForm.antlr4.TaxFormBaseListener;
import uva.TaxForm.antlr4.TaxFormParser;

public class MyTaxFormListener extends TaxFormBaseListener {
	
	public void enterForm(TaxFormParser.FormContext ctx) {
		
		System.out.println("enterForm: " + ctx.getText());
		System.out.println("enterForm.toStringTree(): " + ctx.toStringTree());
	}
	
	public void exitForm(TaxFormParser.FormContext ctx) {
		
		System.out.println("exitForm: " + ctx.toString());
	}
	
	public void enterFormName(TaxFormParser.FormContext ctx) {
		
		System.out.println("enterFormName: " + ctx.getText());
	}
	
	public void exitFormName(TaxFormParser.FormContext ctx) {
		
		System.out.println("exitFormName: " + ctx.toString());
	}
	
	public void enterQuestion(TaxFormParser.TextContext ctx) {
		
		System.out.println("enterQuestion: " + ctx.getText());
	}
	
	public void exitQuestion(TaxFormParser.TextContext ctx) {
		
		System.out.println("exitQuestion: " + ctx.getText());
	}
}
