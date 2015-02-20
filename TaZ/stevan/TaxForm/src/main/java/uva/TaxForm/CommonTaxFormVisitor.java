package uva.TaxForm;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeCondition.NodeConditionIf;
import uva.TaxForm.AST.NodeExp.NodeExp;
import uva.TaxForm.AST.NodeExp.NodeExpArithmetic;
import uva.TaxForm.AST.NodeQuestion.NodeQuestion;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionBoolean;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionInteger;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionMoney;
import uva.TaxForm.AST.NodeQuestion.NodeQuestionString;
import uva.TaxForm.AST.NodeVar.NodeVar;
import uva.TaxForm.AST.Utils.UtilsNode;
import uva.TaxForm.AST.Visitors.VisitorCondition;
import uva.TaxForm.AST.Visitors.VisitorForm;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.ComputedContext;
import uva.TaxForm.antlr4.TaxFormParser.VarTypeContext;

public class CommonTaxFormVisitor extends TaxFormBaseVisitor<Object> {
	
	private NodeForm form = new NodeForm();

	public Integer visitForm( @NotNull TaxFormParser.FormContext ctx ) {
		
		/*
		 * A questionnaire consists of a number of questions arranged in sequential and conditional
		 * structures, and grouping constructs.
		 * 
		 * Sequential composition prescribes the order of presentation.
		 */
		this.form.setName(ctx.varName().getText());
		
		VisitorForm.visit(this, ctx, this.form);
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitQuestion( @NotNull TaxFormParser.QuestionContext ctx, Node node ) {
		
		VarTypeContext varCTX = null;
		
		if (ctx.varType() != null) {
			varCTX = ctx.varType();
		}
		else if (ctx.computed().varType() != null) {
			varCTX = ctx.computed().varType();
		}
		
		//Set NodeQuestionType
		if (varCTX != null) {
			
			//Check for computed question
			Boolean computed = varCTX.getParent().getClass().equals(uva.TaxForm.antlr4.TaxFormParser.ComputedContext.class);
			
			//Boolean
			if (varCTX.BOOLEAN() != null) {
				NodeQuestionBoolean question = UtilsNode.setBooleanQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
			//Money
			else if (varCTX.MONEY() != null) {
				NodeQuestionMoney question = UtilsNode.setMoneyQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
			//Integer
			else if (varCTX.INT() != null) {
				NodeQuestionInteger question = UtilsNode.setIntegerQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
			//String
			else if (varCTX.STRING() != null){
				NodeQuestionString question = UtilsNode.setStringQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
		}
		
		return ctx.getChildCount();
	}
	
	public Integer visitComputed( @NotNull TaxFormParser.ComputedContext ctx, NodeQuestion question ) {
		
		/*System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - computed");
		System.out.println(ctx.getParent().getText());
		System.out.println(question.getClass().equals(uva.TaxForm.AST.NodeQuestionMoney.class));
		
		if (question.getClass().equals(uva.TaxForm.AST.NodeQuestionBoolean.class)) {
			
			NodeQuestionBoolean boolQuestion = (NodeQuestionBoolean) question;
			NodeExp nodeExp = new NodeExp();
			
			boolQuestion.setExpression(nodeExp);
			nodeExp.setLevel(boolQuestion.getLevel() + 1);
			//nodeExp.add(boolQuestion.getVar());
			
			NodeExpArithmetic nodeAssign = new NodeExpArithmetic();
			nodeAssign.setLevel(boolQuestion.getLevel() + 1);
			nodeAssign.setOperator("=");
			nodeExp.add(nodeAssign);
		}
		else if (question.getClass().equals(uva.TaxForm.AST.NodeQuestionMoney.class)) {

			NodeQuestionMoney moneyQuestion = (NodeQuestionMoney) question;
			NodeExp nodeExp = new NodeExp();
			
			moneyQuestion.setExpression(nodeExp);
			nodeExp.setLevel(moneyQuestion.getLevel() + 1);
			//nodeExp.add(moneyQuestion.getVar());
			
			NodeExpArithmetic nodeAssign = new NodeExpArithmetic();
			nodeAssign.setLevel(moneyQuestion.getLevel() + 1);
			nodeAssign.setOperator("=");
			nodeExp.add(nodeAssign);
		}
		else if (question.getClass().equals(uva.TaxForm.AST.NodeQuestionInteger.class)) {

			NodeQuestionInteger integerQuestion = (NodeQuestionInteger) question;
			NodeExp nodeExp = new NodeExp();
			
			integerQuestion.setExpression(nodeExp);
			nodeExp.setLevel(integerQuestion.getLevel() + 1);
			//nodeExp.add(integerQuestion.getVar());
			
			NodeExpArithmetic nodeAssign = new NodeExpArithmetic();
			nodeAssign.setLevel(integerQuestion.getLevel() + 1);
			nodeAssign.setOperator("=");
			nodeExp.add(nodeAssign);
		}
		else if (question.getClass().equals(uva.TaxForm.AST.NodeQuestionString.class)) {

			NodeQuestionString stringQuestion = (NodeQuestionString) question;
			NodeExp nodeExp = new NodeExp();
			
			stringQuestion.setExpression(nodeExp);
			nodeExp.setLevel(stringQuestion.getLevel() + 1);
			//nodeExp.add(stringQuestion.getVar());
			
			NodeExpArithmetic nodeAssign = new NodeExpArithmetic();
			nodeAssign.setLevel(stringQuestion.getLevel() + 1);
			nodeAssign.setOperator("=");
			nodeExp.add(nodeAssign);
		}
		
		

		for (int i=0; i<ctx.expression().size(); i++) {
			
			if (ctx.expression().get(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext.class)) {

				this.visitSingleExpression((SingleExpressionContext) ctx.expression().get(i), nodeExp);
			}
			else if (ctx.expression().get(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext.class)) {
				
				this.visitMinusExpression((MinusExpressionContext) ctx.expression().get(i), nodeExp);
			}
		}*/
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitSingleExpression( @NotNull TaxFormParser.SingleExpressionContext ctx, NodeExp nodeExp ) {
		
		System.out.println("Single: " + ctx.getText());
		
		NodeVar var = new NodeVar();
		var = UtilsNode.getVarInTree(ctx.getText(), this.form);
		
		System.out.println("varName: " + UtilsNode.getVarInTree(ctx.getText(), this.form));
		
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
		
		NodeConditionIf condition = new NodeConditionIf();
		condition.setLevel(node.getLevel() + 1);
		node.add(condition);
		
		VisitorCondition.ifVisit(this, ctx, node);
		
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
