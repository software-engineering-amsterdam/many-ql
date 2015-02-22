package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeCondition.NodeConditionIf;
import uva.TaxForm.AST.NodeExp.Expression;
import uva.TaxForm.AST.NodeExp.Operations.OpArithmetic;
import uva.TaxForm.AST.NodeExp.Operations.OpAssign;
import uva.TaxForm.AST.NodeQuestion.Question;
import uva.TaxForm.AST.NodeVar.Var;
import uva.TaxForm.AST.Utils.UtilsNode;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;
import uva.TaxForm.antlr4.TaxFormParser.ComputedContext;
import uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext;
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
				Question<Boolean> question = UtilsNode.setQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
			//Money
			else if (varCTX.MONEY() != null) {
				Question<Float> question = UtilsNode.setQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
			//Integer
			else if (varCTX.INT() != null) {
				Question<Integer> question = UtilsNode.setQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
			//String
			else if (varCTX.STRING() != null){
				Question<String> question = UtilsNode.setQuestionValues(ctx, node);
				if (computed)
					this.visitComputed((ComputedContext) varCTX.getParent(), question);
			}
		}
		
		return ctx.getChildCount();
	}
	
	public <T> Integer visitComputed( @NotNull TaxFormParser.ComputedContext ctx, Question<?> question ) {
		
		/*System.out.println(ctx.getParent().invokingState + " - " + ctx.invokingState + " - computed");
		System.out.println(ctx.getParent().getText());
		System.out.println(question.getClass().equals(uva.TaxForm.AST.NodeQuestion.Question.class));*/
		
		Expression<? extends Expression<String>> exp = new Expression<>();
		question.setExpression(exp);
		
		exp.setLevel(question.getLevel() + 1);
		exp.add(question.getVar());
		
		OpAssign assign = new OpAssign();
		exp.add(assign);
		
		assign.setOperator("=");

		for (int i=0; i<ctx.allMighty().size(); i++) {
			
			//System.out.println(ctx.allMighty().get(i).expression().getClass());
			this.visitAllMighty((AllMightyContext) ctx.allMighty().get(i), question);
		}
		
		//System.out.println(question.getVar().getName() + " " + question.getExpression().getNodes().toString());
		return ctx.getRuleIndex();
	}
	
	public Integer visitAllMighty( @NotNull TaxFormParser.AllMightyContext ctx, Question<?> question ) {
		
		//System.out.println(ctx.expression().getClass());
		
		if (ctx.expression().getClass().equals(uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext.class)) {

			this.visitSingleExpression((SingleExpressionContext) ctx.expression(), question);
		}
		else if (ctx.expression().getClass().equals(uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext.class)) {
			
			this.visitMinusExpression((MinusExpressionContext) ctx.expression(), question);
		}
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitSingleExpression( @NotNull TaxFormParser.SingleExpressionContext ctx, Question<?> question ) {
		
		Expression<?> exp = question.getExpression();
		Var<?> var = new Var<>();
		var = UtilsNode.getVarInTree(ctx.getText(), this.form);
		exp.add(var);
		
		//System.out.println("expVar: " + var.getName());
		
		return ctx.getRuleIndex();
	}
	
	public Integer visitMinusExpression( @NotNull TaxFormParser.MinusExpressionContext ctx, Question<?> question ) {
		
		Expression<?> exp = question.getExpression();
		OpArithmetic assign = new OpArithmetic();
		exp.add(assign);
		assign.setOperator("-");
		
		//System.out.println("expOp: " + assign.getOperator());
		
		this.visitAllMighty((AllMightyContext) ctx.allMighty(), question);
		
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
