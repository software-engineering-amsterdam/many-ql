package uva.TaxForm;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeConditionIf;
import uva.TaxForm.AST.NodeExp;
import uva.TaxForm.AST.NodeExpArithmetic;
import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeQuestion;
import uva.TaxForm.AST.NodeVar;
import uva.TaxForm.AST.VarBoolean;
import uva.TaxForm.AST.VarInteger;
import uva.TaxForm.AST.VarMoney;
import uva.TaxForm.AST.VarString;
import uva.TaxForm.Utils.NodeUtils;
import uva.TaxForm.Utils.StringUtils;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.ComputedContext;
import uva.TaxForm.antlr4.TaxFormParser.IfConditionContext;
import uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;
import uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.VarTypeContext;

public class CommonTaxFormVisitor extends TaxFormBaseVisitor<Object> {
	
	private NodeForm form = new NodeForm();

	public Integer visitForm( @NotNull TaxFormParser.FormContext ctx ) {
		
		this.form.setName(ctx.varName().getText());
		
		System.out.println(form.toString());
		
		/*
		 * A questionnaire consists of a number of questions arranged in sequential and conditional
		 * structures, and grouping constructs.
		 * 
		 * Sequential composition prescribes the order of presentation.
		 */
		
		//TODO: Replace by generic static method? in uva.TaxForm.Utils.NodeUtils
		for ( int i=0; i<ctx.children.size(); i++ ) {
			
			//System.out.println(ctx.getChild(i).getClass().getCanonicalName());
			
			//QuestionContext
			if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.QuestionContext.class)) {
				this.visitQuestion((QuestionContext) ctx.getChild(i), this.form);
			}
			//IfConditionContext
			else if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.IfConditionContext.class)) {
				this.visitIfCondition((IfConditionContext) ctx.getChild(i), this.form);
			}
		}
		
		//visitChildren(ctx);
		return ctx.getRuleIndex();
	}
	
	public Integer visitQuestion( @NotNull TaxFormParser.QuestionContext ctx, Node node ) {
		
		//System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - question");
		
		NodeQuestion question = new NodeQuestion();
		question.setLabel(ctx.label().getText());
		question.setLevel(node.getLevel() + 1);
		node.add(question);
		
		VarTypeContext varCTX = null;
		
		if (ctx.varType() != null) {
			varCTX = ctx.varType();
		}
		else if (ctx.computed().varType() != null) {
			varCTX = ctx.computed().varType();
		}
		
		//Set VarType
		if (varCTX != null) {
			//Boolean
			if (varCTX.BOOLEAN() != null) {
				VarBoolean var = new VarBoolean();
				var.setName(ctx.varName().getText());
				question.setVar(var);
			}
			//Money
			else if (varCTX.MONEY() != null) {
				VarMoney var = new VarMoney();
				var.setName(ctx.varName().getText());
				question.setVar(var);
			}
			//Integer
			else if (varCTX.INT() != null) {
				VarInteger var = new VarInteger();
				var.setName(ctx.varName().getText());
				question.setVar(var);
			}
			//String
			else if (varCTX.STRING() != null){
				VarString var = new VarString();
				var.setName(ctx.varName().getText());
				question.setVar(var);
			}
			
			System.out.println(question.toString());
		}
		
		//Check for Computed Question
		if (ctx.computed() != null) {
			
			for (int i=0; i<ctx.children.size(); i++) {
				if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.ComputedContext.class)) {
					this.visitComputed((ComputedContext) ctx.getChild(i), question);
				}
			}
		}
		
		//System.out.println(StringUtils.repeat("\t", question.getLevel()) + question.getName());
		
		return ctx.getChildCount();
	}
	
	public Integer visitComputed( @NotNull TaxFormParser.ComputedContext ctx, NodeQuestion question ) {
		
		System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - computed");
		/*System.out.println(ctx.getParent().getText());
		System.out.println(question.getClass().getName());*/
		
		NodeExp nodeExp = new NodeExp();
		question.setExpression(nodeExp);
		
		nodeExp.setLevel(question.getLevel() + 1);
		nodeExp.add(question.getVar());
		
		NodeExpArithmetic nodeAssign = new NodeExpArithmetic();
		nodeAssign.setLevel(question.getLevel() + 1);
		nodeAssign.setOperator("=");
		nodeExp.add(nodeAssign);
		
		

		for (int i=0; i<ctx.expression().size(); i++) {
			
			if (ctx.expression().get(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext.class)) {

				this.visitSingleExpression((SingleExpressionContext) ctx.expression().get(i), nodeExp);
			}
			else if (ctx.expression().get(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext.class)) {
				
				this.visitMinusExpression((MinusExpressionContext) ctx.expression().get(i), nodeExp);
			}
		}
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitSingleExpression( @NotNull TaxFormParser.SingleExpressionContext ctx, NodeExp nodeExp ) {
		
		System.out.println("Single: " + ctx.getText());
		
		NodeVar var = NodeUtils.getVarInTree(ctx.getText(), this.form);
		
		System.out.println("varName: " + var.getName());
		
		//Set VarType
		/*if (ctx.varType() != null) {
			//Boolean
			if (ctx.varType().BOOLEAN() != null) {
				VarTypeBoolean vType = new VarTypeBoolean();
				question.setType(vType);
			}
			//Money
			else if (ctx.varType().MONEY() != null) {
				VarTypeMoney qType = new VarTypeMoney();
				question.setType(qType);
			}
			//Integer
			else if (ctx.varType().INT() != null) {
				VarTypeInteger qType = new VarTypeInteger();
				question.setType(qType);
			}
			//String
			else if (ctx.varType().STRING() != null){
				VarTypeString qType = new VarTypeString();
				question.setType(qType);
			}
		}*/
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitMinusExpression( @NotNull TaxFormParser.MinusExpressionContext ctx, NodeExp nodeExp ) {
		
		System.out.println("Minus: " + ctx.getParent().invokingState + " - " + ctx.invokingState + " - " + ctx.getText());
		
		//System.out.println(ctx.MINUS().getText());
		
		NodeExpArithmetic node = new NodeExpArithmetic();
		node.setOperator(ctx.MINUS().getText());
		nodeExp.add(node);
		
		//System.out.println(ctx.getChild(ctx.getChildCount() - 1).getText());
		
		//Look for the variable with this varName
		String varName  = ctx.getChild(ctx.getChildCount() - 1).getText();
		
		// Go up all the way to the root of the tree
		ParserRuleContext prc = ctx;
		while (prc.depth() != 1) {
			prc = prc.getParent();
		}
		//System.out.println(prc.getText());
		
		//TODO: Need a function the crawl in a given tree to find a certain variable, by name
		
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitIfCondition( @NotNull TaxFormParser.IfConditionContext ctx, Node node ) {
		
		//System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - ifCondition");
		
		NodeConditionIf condition = new NodeConditionIf();
		condition.setLevel(node.getLevel() + 1);
		node.add(condition);
		
		//System.out.println(StringUtils.repeat("\t", condition.getLevel()) + "IfCondition");
		
		//TODO: Replace by generic static method? in uva.TaxForm.Utils.NodeUtils
		for ( int i=0; i<ctx.children.size(); i++ ) {
			
			//System.out.println(ctx.getChild(i).getClass().getCanonicalName());
			
			//QuestionContext
			if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.QuestionContext.class)) {
				this.visitQuestion((QuestionContext) ctx.getChild(i), condition);
			}
			//IfConditionContext
			/*else if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.IfConditionContext.class)) {
				this.visitIfCondition((IfConditionContext) ctx.getChild(i), condition);
			}*/
		}
		
		
		
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
