package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Node;
import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeCondition.NodeConditionIf;
import uva.TaxForm.AST.NodeExp.Expression;
import uva.TaxForm.AST.NodeExp.Operations.OpAssign;
import uva.TaxForm.AST.NodeQuestion.Question;
import uva.TaxForm.AST.NodeVar.Var;
import uva.TaxForm.AST.Utils.UtilsNode;
import uva.TaxForm.Utils.StringUtils;
import uva.TaxForm.antlr4.TaxFormBaseVisitor;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AddExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;
import uva.TaxForm.antlr4.TaxFormParser.AndExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.ComputedContext;
import uva.TaxForm.antlr4.TaxFormParser.DivideExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.EqualExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.LowerEqualExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.LowerExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.MultiplyExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.NotEqualExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.NotExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.OrExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.UpperEqualExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.UpperExpressionContext;
import uva.TaxForm.antlr4.TaxFormParser.VarTypeContext;

public class CommonTaxFormVisitor extends TaxFormBaseVisitor<Object> {
	
	private NodeForm form = new NodeForm();
	
	/*public NodeForm getAST( TaxFormParser.FormContext ctx ) {
		
		return this.visitForm( ctx );
	}*/

	//Set the name of the form and continue visit... with VisitForm.visit(this, FormContext, NodeForm);
	public NodeForm visitForm( @NotNull TaxFormParser.FormContext ctx ) {
		
		this.form.setName(ctx.varName().getText());
		System.out.println( StringUtils.repeat("\t", form.getLevel()) + form.getName() );
		VisitorForm.visit(this, ctx, this.form);
		
		return this.form;
	}

	//Visit Question, check if result is computed and define the type(Boolean/Money/Integer/String) of the question
	public void visitQuestion( @NotNull TaxFormParser.QuestionContext ctx, Node node ) {
		
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
			Question<?> question = null;
			
			//Boolean
			if (varCTX.BOOLEAN() != null) {
				question = new Question<Boolean>();
			}
			//Money
			else if (varCTX.MONEY() != null) {
				question = new Question<Float>();
			}
			//Integer
			else if (varCTX.INT() != null) {
				question = new Question<Integer>();
			}
			//String
			else if (varCTX.STRING() != null){
				question = new Question<String>();
			}
			
			question = UtilsNode.setQuestionValues(ctx, node);
			System.out.println( StringUtils.repeat("\t", question.getLevel()) + question.getVar().getName() + " " + question.getVar().toString() );
			if (computed)
				this.visitComputed((ComputedContext) varCTX.getParent(), question, form);
		}
	}
	
	//Visit Computed question, define the expression used e.g. money = (sellingPrice - privateDebt)
	public <T> void visitComputed( @NotNull TaxFormParser.ComputedContext ctx, Question<?> question, NodeForm form ) {
		
		Expression<? extends Expression<String>> exp = new Expression<>();
		question.setExpression(exp);
		exp.setLevel(question.getLevel() + 1);
		exp.add(question.getVar());
		
		OpAssign assign = new OpAssign();
		exp.add(assign);
		assign.setOperator("=");

		for (int i=0; i<ctx.allMighty().size(); i++) {
			
			CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty().get(i), question, form);
		}
		
/*		System.out.println( StringUtils.repeat("\t", question.getLevel()) 
							+ question.getVar().getName() + " " 
							+ question.getExpression().getNodes().toString());*/
		for (Node n : question.getExpression().getNodes()) {
			System.out.println( StringUtils.repeat("\t", n.getLevel()) 
								+ n.toString());
		}
	}
	
	//AllMighty is recursively checking the expression(s)
	public static void visitAllMighty( @NotNull TaxFormParser.AllMightyContext ctx, Question<?> question, NodeForm form ) {
		
		Class<?> expClass = ctx.expression().getClass();
		
		//Single
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.SingleExpressionContext.class))
			visitSingleExpression((SingleExpressionContext) ctx.expression(), question, form);
		
		/* Arithmetic */
		//Minus
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.MinusExpressionContext.class))
			VisitorArithmetic.visitMinus((MinusExpressionContext) ctx.expression(), question, form);
		//Add
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.AddExpressionContext.class))
			VisitorArithmetic.visitAdd((AddExpressionContext) ctx.expression(), question, form);
		//Multiply
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.MultiplyExpressionContext.class))
			VisitorArithmetic.visitMultiply((MultiplyExpressionContext) ctx.expression(), question, form);
		//Divide
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.DivideExpressionContext.class))	
			VisitorArithmetic.visitDivide((DivideExpressionContext) ctx.expression(), question, form);
		
		/* Boolean */
		//And
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.AndExpressionContext.class))
			VisitorBoolean.visitAnd((AndExpressionContext) ctx.expression(), question, form);
		//Or
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.OrExpressionContext.class))
			VisitorBoolean.visitOr((OrExpressionContext) ctx.expression(), question, form);
		//Not
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.NotExpressionContext.class))
			VisitorBoolean.visitNot((NotExpressionContext) ctx.expression(), question, form);
		
		/* Comparison */
		//Lower
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.LowerExpressionContext.class))
			VisitorComparison.visitLower((LowerExpressionContext) ctx.expression(), question, form);
		//Upper
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.UpperExpressionContext.class))
			VisitorComparison.visitUpper((UpperExpressionContext) ctx.expression(), question, form);
		//LowerEqual
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.LowerEqualExpressionContext.class))
			VisitorComparison.visitLowerEqual((LowerEqualExpressionContext) ctx.expression(), question, form);
		//UpperEqual
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.UpperEqualExpressionContext.class))
			VisitorComparison.visitUpperEqual((UpperEqualExpressionContext) ctx.expression(), question, form);
		//Equal
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.EqualExpressionContext.class))
			VisitorComparison.visitEqual((EqualExpressionContext) ctx.expression(), question, form);
		//NotEqual
		if (expClass.equals(uva.TaxForm.antlr4.TaxFormParser.NotEqualExpressionContext.class))
			VisitorComparison.visitNotEqual((NotEqualExpressionContext) ctx.expression(), question, form);
	}
	
	public static void visitSingleExpression( @NotNull TaxFormParser.SingleExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		Expression<?> exp = question.getExpression();
		Var<?> var = new Var<>();
		var = UtilsNode.getVarInTree(ctx.getText(), form);
		exp.add(var);
		
		//System.out.println("expVar: " + var.getName());
	}
	
	public Integer visitIfCondition( @NotNull TaxFormParser.IfConditionContext ctx, Node node ) {
		
		NodeConditionIf condition = new NodeConditionIf();
		condition.setLevel(node.getLevel() + 1);
		node.add(condition);
		
		VisitorCondition.ifVisit(this, ctx, condition);
		
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
