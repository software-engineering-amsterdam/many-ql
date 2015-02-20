package uva.TaxForm;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeExpression;
import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeIfCondition;
import uva.TaxForm.AST.NodeQuestion;
import uva.TaxForm.AST.QuestionTypeBoolean;
import uva.TaxForm.AST.QuestionTypeInteger;
import uva.TaxForm.AST.QuestionTypeMoney;
import uva.TaxForm.AST.QuestionTypeString;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.ComputedContext;
import uva.TaxForm.antlr4.TaxFormParser.IfConditionContext;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;

public class CommonTaxFormVisitor extends TaxFormBaseVisitor<Object> {

	public Integer visitForm( @NotNull TaxFormParser.FormContext ctx ) {
		
		/*System.out.println(ctx.invokingState + " - " + ctx.invokingState + " - form");
		System.out.println(ctx.children.size());*/
		
		NodeForm form = new NodeForm();
		form.setName(ctx.varName().getText());
		
		System.out.println(form.toString());
		
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
		
		NodeQuestion question = new NodeQuestion();
		question.setName(ctx.varName().getText());
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		
		//Set QuestionType
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
		
		System.out.println(question.toString());
		
		//Check for Computed Question
		if (ctx.computed() != null) {
			
			for (int i=0; i<ctx.children.size(); i++) {
				if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.ComputedContext.class)) {
					this.visitComputed((ComputedContext) ctx.getChild(i), question);
				}
			}
		}
		
		node.add(question);
		
		
		//System.out.println(StringUtils.repeat("\t", question.getLevel()) + question.getName());
		
		return ctx.getChildCount();
	}
	
	public Integer visitComputed( @NotNull TaxFormParser.ComputedContext ctx, Node node ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - computed");
		//System.out.println(node.toString());
		
		NodeExpression nodeExp = new NodeExpression();
		
		/*System.out.println(ctx.expression().getChildCount());
		for (int i=0; i<ctx.expression().getChildCount(); i++) {
			System.out.println(ctx.expression().getChild(i).getText());
		}*/
		
		//visitChildren(ctx);
		return ctx.getRuleIndex();
	}
	
	public Integer visitExpression( @NotNull TaxFormParser.ExpressionContext ctx ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		return ctx.getRuleIndex();
	}
	
	public Integer visitIfCondition( @NotNull TaxFormParser.IfConditionContext ctx, Node node ) {
		
		//System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - ifCondition");
		
		NodeIfCondition condition = new NodeIfCondition();
		condition.setLevel(node.getLevel() + 1);
		
		//System.out.println(StringUtils.repeat("\t", condition.getLevel()) + "IfCondition");
		
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
}
