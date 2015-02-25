package org.uva.ql.ast.builder;

import org.uva.ql.antlr.QLBaseVisitor;
import org.uva.ql.antlr.QLParser.BlockContext;
import org.uva.ql.antlr.QLParser.ExprAndContext;
import org.uva.ql.antlr.QLParser.ExprDivideContext;
import org.uva.ql.antlr.QLParser.ExprEqualContext;
import org.uva.ql.antlr.QLParser.ExprGreaterContext;
import org.uva.ql.antlr.QLParser.ExprGreaterEqualContext;
import org.uva.ql.antlr.QLParser.ExprLessContext;
import org.uva.ql.antlr.QLParser.ExprLessEqualContext;
import org.uva.ql.antlr.QLParser.ExprMinusContext;
import org.uva.ql.antlr.QLParser.ExprMultiplyContext;
import org.uva.ql.antlr.QLParser.ExprNegativeContext;
import org.uva.ql.antlr.QLParser.ExprNotContext;
import org.uva.ql.antlr.QLParser.ExprNotEqualContext;
import org.uva.ql.antlr.QLParser.ExprOrContext;
import org.uva.ql.antlr.QLParser.ExprParenthesesContext;
import org.uva.ql.antlr.QLParser.ExprPlusContext;
import org.uva.ql.antlr.QLParser.ExprPositiveContext;
import org.uva.ql.antlr.QLParser.FormContext;
import org.uva.ql.antlr.QLParser.IfContext;
import org.uva.ql.antlr.QLParser.IfElseContext;
import org.uva.ql.antlr.QLParser.LiteralBoolContext;
import org.uva.ql.antlr.QLParser.LiteralIdContext;
import org.uva.ql.antlr.QLParser.LiteralIntContext;
import org.uva.ql.antlr.QLParser.LiteralStrContext;
import org.uva.ql.antlr.QLParser.QuestionComputeContext;
import org.uva.ql.antlr.QLParser.QuestionNormalContext;
import org.uva.ql.antlr.QLParser.QuestionnaireContext;
import org.uva.ql.antlr.QLParser.StatementContext;
import org.uva.ql.antlr.QLParser.TypeBoolContext;
import org.uva.ql.antlr.QLParser.TypeIntContext;
import org.uva.ql.antlr.QLParser.TypeStrContext;
import org.uva.ql.ast.Node;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.association.Parenthese;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Minus;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Plus;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.Type;

public class QLImplVisitor extends QLBaseVisitor<Node> {

	@Override
	public Node visitQuestionnaire(QuestionnaireContext ctx) {
		System.out.println("Visiting Questionnaire...");
		Questionnaire questionnaire = new Questionnaire();
		for (FormContext formContext : ctx.form()) {
			//questionnaire.addForm((Form) visitForm(formContext));
			questionnaire.addForm((Form) formContext.accept(this));
		}
		return questionnaire;
	}

	@Override
	public Node visitForm(FormContext ctx) {
		System.out.println("Visiting Form...");
		Identifier id = new Identifier(ctx.Identifier().getText());
		Block block = (Block) ctx.block().accept(this);
		return new Form(id, block);
	}
	
	@Override
	public Node visitBlock(BlockContext ctx) {
		System.out.println("Visiting Block...");
		Block block = new Block();
		for (StatementContext statementContext : ctx.statement()) {
			block.addStatement((Statement) statementContext.accept(this));
		}
		return block;
	}

	@Override
	public Node visitIf(IfContext ctx) {
		System.out.println("Visiting If...");
		Expression expr = (Expression) ctx.expression().accept(this);
		Block block = (Block) ctx.ifBody.accept(this);
		return new IfStatement(expr, block);
	}

	@Override
	public Node visitIfElse(IfElseContext ctx) {
		System.out.println("Visiting If-Else...");
		Expression expr = (Expression) ctx.expression().accept(this);
		Block ifBlock = (Block) ctx.ifBody.accept(this);
		Block elseBlock = (Block) ctx.elseBody.accept(this);
		IfElseStatement ifElseStatement = new IfElseStatement(expr, ifBlock, elseBlock);
		return ifElseStatement;
	}

	@Override
	public Node visitQuestionNormal(QuestionNormalContext ctx) {
		System.out.println("Visiting Normal Question...");
		Identifier id = new Identifier(ctx.questionName().getText());
		// Remove the First and Last Quotes
		StrLiteral label = new StrLiteral(ctx.questionLabel().getText().replaceAll("^\"|\"$", ""));
		Type type = (Type) ctx.questionType().accept(this);
		return new QuestionNormal(id, label, type);
	}

	@Override
	public Node visitQuestionCompute(QuestionComputeContext ctx) {
		System.out.println("Visiting Compute Question...");
		Identifier id = new Identifier(ctx.questionName().Identifier().getText());
		// Remove the First and Last Quotes
		StrLiteral label = new StrLiteral(ctx.questionLabel().getText().replaceAll("^\"|\"$", ""));
		Type type = (Type) ctx.questionType().accept(this);
		Expression expr = (Expression) ctx.expression().accept(this);
		return new QuestionCompute(id, label, type, expr);
	}

	@Override
	public Node visitTypeInt(TypeIntContext ctx) {
		System.out.println("Visiting Type Int");
		return new IntType();
	}
	
	@Override
	public Node visitTypeBool(TypeBoolContext ctx) {
		System.out.println("Visiting Type Bool");
		return new BoolType();
	}
	
	@Override
	public Node visitTypeStr(TypeStrContext ctx) {
		System.out.println("Visiting Type Str");
		return new StrType();
	}
	
	//=================================================================
	//	Expression
	//=================================================================

	@Override
	public Node visitExprNot(ExprNotContext ctx) {
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Not(expr);
	}

	@Override
	public Node visitExprPositive(ExprPositiveContext ctx) {
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Positive(expr);
	}

	@Override
	public Node visitExprNegative(ExprNegativeContext ctx) {
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Negative(expr);
	}

	@Override
	public Node visitExprPlus(ExprPlusContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Plus(left, right);
	}

	@Override
	public Node visitExprMinus(ExprMinusContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Minus(left, right);
	}

	@Override
	public Node visitExprMultiply(ExprMultiplyContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Multiply(left, right);
	}

	@Override
	public Node visitExprDivide(ExprDivideContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Divide(left, right);
	}

	@Override
	public Node visitExprAnd(ExprAndContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new And(left, right);
	}

	@Override
	public Node visitExprOr(ExprOrContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Or(left, right);
	}

	@Override
	public Node visitExprEqual(ExprEqualContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Equal(left, right);
	}

	@Override
	public Node visitExprNotEqual(ExprNotEqualContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new NotEqual(left, right);
	}

	@Override
	public Node visitExprGreater(ExprGreaterContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Greater(left, right);
	}

	@Override
	public Node visitExprGreaterEqual(ExprGreaterEqualContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new GreaterEqual(left, right);
	}

	@Override
	public Node visitExprLess(ExprLessContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Less(left, right);
	}

	@Override
	public Node visitExprLessEqual(ExprLessEqualContext ctx) {
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new LessEqual(left, right);
	}

	@Override
	public Node visitLiteralId(LiteralIdContext ctx) {
		return new Identifier(ctx.Identifier().getText());
	}

	@Override
	public Node visitLiteralInt(LiteralIntContext ctx) {
		return new IntLiteral(Integer.parseInt(ctx.getText()));
	}

	@Override
	public Node visitLiteralBool(LiteralBoolContext ctx) {
		return ctx.BooleanLiteral().accept(this);
	}

	@Override
	public Node visitLiteralStr(LiteralStrContext ctx) {
		return new StrLiteral(ctx.StringLiteral().getText());
	}

	@Override
	public Node visitExprParentheses(ExprParenthesesContext ctx) {
		return new Parenthese((Expression) ctx.expression().accept(this));
	}
	
}
