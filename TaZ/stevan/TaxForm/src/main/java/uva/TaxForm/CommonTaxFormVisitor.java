package uva.TaxForm;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Form;
import uva.TaxForm.AST.IfCondition;
import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.Question;
import uva.TaxForm.AST.QuestionType;
import uva.TaxForm.AST.QuestionTypeBoolean;
import uva.TaxForm.AST.QuestionTypeInteger;
import uva.TaxForm.AST.QuestionTypeMoney;
import uva.TaxForm.AST.QuestionTypeString;
import uva.TaxForm.Utils.StringUtils;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.IfConditionContext;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;

public class CommonTaxFormVisitor extends TaxFormBaseVisitor<Object> {

	public Integer visitForm( @NotNull TaxFormParser.FormContext ctx ) {
		
		/*System.out.println(ctx.invokingState + " - " + ctx.invokingState + " - form");
		System.out.println(ctx.children.size());*/
		
		System.out.println("Form");
		
		Form form = new Form();
		form.setName(ctx.varName().getText());
		
		/*
		 * A questionnaire consists of a number of questions arranged in sequential and conditional
		 * structures, and grouping constructs.
		 * 
		 * Sequential composition prescribes the order of presentation.
		 */
		
		//TODO: Replace by generic static method in uva.TaxForm.Utils.NodeUtils
		for ( int i=0; i<ctx.children.size(); i++ ) {
			
			//System.out.println(ctx.getChild(i).getClass().getCanonicalName());
			
			//QuestionContext
			if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.QuestionContext.class)) {
				this.visitQuestion((QuestionContext) ctx.getChild(i), form);
			}
			//IfConditionContext
			else if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.IfConditionContext.class)) {
				this.visitIfCondition((IfConditionContext) ctx.getChild(i), form);
			}
		}
		
		//visitChildren(ctx);
		return ctx.getRuleIndex();
	}
	
	public Integer visitQuestion( @NotNull TaxFormParser.QuestionContext ctx, Node node ) {
		
		//System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - question");
		
		Question question = new Question();
		question.setName(ctx.varName().getText());
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		//question.setType(ctx.varType().getText());
		//System.out.println(ctx.varType().getChildCount());
		
		//Not Computed
		if (ctx.varType() != null) {
			//Boolean
			if (ctx.varType().BOOLEAN() != null) {
				QuestionTypeBoolean qType = new QuestionTypeBoolean();
				question.setType(qType);
			}
			//Money
			else if (ctx.varType().MONEY() != null) {
				QuestionTypeMoney qType = new QuestionTypeMoney();
				question.setType(qType);
			}
			//Integer
			else if (ctx.varType().INT() != null) {
				QuestionTypeInteger qType = new QuestionTypeInteger();
				question.setType(qType);
			}
			//String
			else if (ctx.varType().STRING() != null){
				QuestionTypeString qType = new QuestionTypeString();
				question.setType(qType);
			}
		}
		//Computed
		else {
			/*System.out.println(ctx.computed().getText());
			System.out.println(ctx.computed().getChildCount());*/
		}
		
		node.add(question);
		
		System.out.println(StringUtils.repeat("\t", question.getLevel()) + "Question");
		
		//visitChildren(ctx);
		return ctx.getChildCount();
	}
	
	public Integer visitIfCondition( @NotNull TaxFormParser.IfConditionContext ctx, Node node ) {
		
		//System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - ifCondition");
		
		IfCondition condition = new IfCondition();
		condition.setLevel(node.getLevel() + 1);
		
		System.out.println(StringUtils.repeat("\t", condition.getLevel()) + "IfCondition");
		
		//TODO: Replace by generic static method in uva.TaxForm.Utils.NodeUtils
		for ( int i=0; i<ctx.children.size(); i++ ) {
			
			//System.out.println(ctx.getChild(i).getClass().getCanonicalName());
			
			//QuestionContext
			if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.QuestionContext.class)) {
				this.visitQuestion((QuestionContext) ctx.getChild(i), condition);
			}
			//IfConditionContext
			else if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.IfConditionContext.class)) {
				this.visitIfCondition((IfConditionContext) ctx.getChild(i), condition);
			}
		}
		
		node.add(condition);
		
		//visitChildren(ctx);
		return ctx.getRuleIndex();
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
	
	public Integer visitExpression( @NotNull TaxFormParser.ExpressionContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		return ctx.getRuleIndex();
	}
}
