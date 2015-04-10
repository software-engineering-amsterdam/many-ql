package qlProject.grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qlProject.ast.Questionnaire;
import qlProject.ast.expression.IExpression;
import qlProject.ast.expression.Id;
import qlProject.ast.expression.ParenthesisExpr;
import qlProject.ast.expression.StringExpr.ConcatenationExpr;
import qlProject.ast.expression.StringExpr.StringLiteral;
import qlProject.ast.expression.arithmeticExpr.AdditionExpr;
import qlProject.ast.expression.arithmeticExpr.DivisionExpr;
import qlProject.ast.expression.arithmeticExpr.IntLiteral;
import qlProject.ast.expression.arithmeticExpr.MultiplicationExpr;
import qlProject.ast.expression.arithmeticExpr.NegationExpr;
import qlProject.ast.expression.arithmeticExpr.SubtractionExpr;
import qlProject.ast.expression.booleanExpr.BoolLiteral;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.EqualExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.UnequalExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.AndExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.NotExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.OrExpr;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.Assignment;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.ast.type.BooleanType;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.type.Type;

public class ParserToASTVisitor extends qlGrammarBaseVisitor<Object>{

	private final Map<String, Object> map = new HashMap<String, Object>();

	@Override public Object visitForm(qlGrammarParser.FormContext ctx) {

		List<IStatement> statementsList = new ArrayList<IStatement>();
		for (qlGrammarParser.StatementContext statementContext: ctx.statement())	{
			statementsList.add((IStatement)statementContext.accept(this));
		}
		return new Questionnaire(statementsList);
	}

	@Override public Object visitConditionalQuestionsList(qlGrammarParser.ConditionalQuestionsListContext ctx) { 

		List<IStatement> isTrueList = new ArrayList<IStatement>();
		List<IStatement> isFalseList = new ArrayList<IStatement>();

		for (qlGrammarParser.StatementContext statementContext: ctx.ifPart){
			isTrueList.add((IStatement)statementContext.accept(this));
		}
		for (qlGrammarParser.StatementContext statementContext: ctx.elsePart){
			isFalseList.add((Assignment)statementContext.accept(this));
		}
		return new IfStatement((IExpression) ctx.expr().accept(this), isTrueList, isFalseList);}

	@Override public Object visitIntLiteral(qlGrammarParser.IntLiteralContext ctx) { 
		return new IntLiteral(Integer.parseInt(ctx.INT().getText())); }

	@Override
	public Object visitStringLiteral(qlGrammarParser.StringLiteralContext ctx){
		return new StringLiteral(ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1));
	}

	@Override public Object visitBoolLiteral(qlGrammarParser.BoolLiteralContext ctx) { 
		if (ctx.bLiteral.getType() == qlGrammarParser.TRUE)
			return new BoolLiteral(true);
		return new BoolLiteral(false);
	}

	@Override public Object visitIntType(qlGrammarParser.IntTypeContext ctx) { 
		return new IntType();}
	
	@Override public Object visitParens(qlGrammarParser.ParensContext ctx) { 
		return new ParenthesisExpr((IExpression)ctx.expr().accept(this)); }


	@Override public Object visitAnd (qlGrammarParser.AndContext ctx) {
		return new AndExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitOr (qlGrammarParser.OrContext ctx) {
		return new OrExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitNot (qlGrammarParser.NotContext ctx) {
		return new NotExpr((IExpression)ctx.expr().accept(this));
	}

	@Override public Object visitGreaterThan(qlGrammarParser.GreaterThanContext ctx) {
		return new BiggerThanExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitGreaterOrEq(qlGrammarParser.GreaterOrEqContext ctx) { 
		return new BiggerEqExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitUnequal(qlGrammarParser.UnequalContext ctx) { 
		return new UnequalExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitEqual(qlGrammarParser.EqualContext ctx) { 
		return new EqualExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitLessThan(qlGrammarParser.LessThanContext ctx) { 
		return new SmallerThanExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitLessOrEq(qlGrammarParser.LessOrEqContext ctx) {
		return new SmallerEqExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this));
	}

	@Override public Object visitId(qlGrammarParser.IdContext ctx) { 
		return new Id(ctx.ID().getText()); }

	@Override public Object visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
		return new BooleanType();}

	@Override public Object visitStrType(qlGrammarParser.StrTypeContext ctx) { 
		return new StringType();}

	@Override public Object visitBasicQuestion(qlGrammarParser.BasicQuestionContext ctx) { 
		map.put(ctx.ID().getText(), (Type) ctx.type().accept(this));
		return new DirectAssignment(ctx.ID().getText(),
				ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1)
				,(Type) ctx.type().accept(this)); }

	@Override public Object visitComputedQuestion(qlGrammarParser.ComputedQuestionContext ctx) { 
		map.put(ctx.ID().getText(), (Type) ctx.type().accept(this));
		return new ComputedAssignment(ctx.ID().getText(),
				ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
				(Type) ctx.type().accept(this), (IExpression) ctx.expr().accept(this));
	}

	@Override public Object visitNegate(qlGrammarParser.NegateContext ctx) { 
		return new NegationExpr((IExpression)ctx.expr().accept(this));
	}

	@Override public Object visitAddSubtract(qlGrammarParser.AddSubtractContext ctx) { 
		if (ctx.op.getType() == qlGrammarParser.ADD){
			return new AdditionExpr((IExpression)ctx.expr(0).accept(this),
					(IExpression)ctx.expr(1).accept(this)); }
		return new SubtractionExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this)); } 

	@Override public Object visitMultiplyDivide(qlGrammarParser.MultiplyDivideContext ctx) { 
		if (ctx.op.getType() == qlGrammarParser.MUL){
			return new MultiplicationExpr((IExpression)ctx.expr(0).accept(this),
					(IExpression)ctx.expr(1).accept(this)); }
		return new DivisionExpr((IExpression)ctx.expr(0).accept(this),
				(IExpression)ctx.expr(1).accept(this)); } 

	@Override public Object visitConcatenationExpression(qlGrammarParser.ConcatenationExpressionContext ctx) { 
		return new ConcatenationExpr((IExpression)ctx.expr(0).accept(this), 
				(IExpression)ctx.expr(1).accept(this)); }
	
}
