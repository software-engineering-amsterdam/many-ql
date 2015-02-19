package uva.TaxForm;

import org.antlr.v4.runtime.misc.NotNull;
import uva.TaxForm.AST.Form;
import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.Question;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;

public class CommonTaxFormVisitor extends TaxFormBaseVisitor<Object> {

	public Integer visitForm( @NotNull TaxFormParser.FormContext ctx ) {
		
		//System.out.println(ctx.invokingState + " - " + ctx.invokingState + " - form");
		
		Form form = new Form();
		form.setName(ctx.varName().getText());
		
		for ( QuestionContext question : ctx.question()) {
			
			this.visitQuestion(question, form);
			//System.out.println(question.getText());
		}
		
		//visitChildren(ctx);
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitQuestion( @NotNull TaxFormParser.QuestionContext ctx, Node node ) {
		
		//System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - question");
		
		Question question = new Question();
		question.setLabel(ctx.label().getText());
		node.add(question);
		
		//visitChildren(ctx);
		return ctx.getChildCount();
	}
	
	public Integer visitLabel( @NotNull TaxFormParser.LabelContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		return ctx.getRuleIndex();
	}
	
	public Integer visitVarName( @NotNull TaxFormParser.VarNameContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		return ctx.getRuleIndex();
	}
	
	public Integer visitVarType( @NotNull TaxFormParser.VarTypeContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		return ctx.getRuleIndex();
	}
	
	public Integer visitComputed( @NotNull TaxFormParser.ComputedContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - computed");
		visitChildren(ctx);
		return ctx.getRuleIndex();
	}
	
	public Integer visitIfCondition( @NotNull TaxFormParser.IfConditionContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - ifCondition");
		//visitChildren(ctx);
		return ctx.getRuleIndex();
	}
	
	public Integer visitExpression( @NotNull TaxFormParser.ExpressionContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		return ctx.getRuleIndex();
	}
}
