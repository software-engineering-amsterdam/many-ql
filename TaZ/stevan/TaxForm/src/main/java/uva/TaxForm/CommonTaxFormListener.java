package uva.TaxForm;

import uva.TaxForm.antlr4.TaxFormBaseListener;
import uva.TaxForm.antlr4.TaxFormParser;

public class CommonTaxFormListener extends TaxFormBaseListener {
	
	public void enterForm(TaxFormParser.FormContext ctx) {
		
		System.out.println("Form: " + ctx.getText());
		//System.out.println("enterForm.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterFormName(TaxFormParser.FormNameContext ctx) {
		
		System.out.println("FormName: " + ctx.getText());
		//System.out.println("enterFormName.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}

	public void enterQuestion(TaxFormParser.QuestionContext ctx) {
		
		System.out.println("Question: " + ctx.getText());
		//System.out.println("enterQuestion.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterAnswer(TaxFormParser.AnswerContext ctx) {
		
		System.out.println("Answer: " + ctx.getText());
		//System.out.println("enterAnswer.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterVarName(TaxFormParser.VarNameContext ctx) {
		
		System.out.println("varName: " + ctx.getText());
		//System.out.println("enterVariableName.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
	
	public void enterVarType(TaxFormParser.VarTypeContext ctx) {
		
		System.out.println("varType: " + ctx.getText());
		//System.out.println("enterVariableName.toStringTree(): " + ctx.toStringTree());
		//System.out.println( ctx.depth() );
	}
}
