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
import org.uva.ql.antlr.QLParser.QuestionIdentifierContext;
import org.uva.ql.antlr.QLParser.QuestionLabelContext;
import org.uva.ql.antlr.QLParser.QuestionNormalContext;
import org.uva.ql.antlr.QLParser.QuestionnaireContext;
import org.uva.ql.antlr.QLParser.StatementContext;
import org.uva.ql.antlr.QLParser.TypeBoolContext;
import org.uva.ql.antlr.QLParser.TypeIntContext;
import org.uva.ql.antlr.QLParser.TypeStrContext;
import org.uva.ql.ast.QLNode;
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
import org.uva.ql.ast.expression.literal.BoolLiteral;
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
import org.uva.utility.CodePosition;

public class QLImplVisitor extends QLBaseVisitor<QLNode> {

	private final String DOUBLE_QUOTE_ESCAPE_PATTERN = "^\"|\"$"; 
	
	@Override
	public QLNode visitQuestionnaire(QuestionnaireContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Questionnaire questionnaire = new Questionnaire(pos);
		for (FormContext formContext : ctx.form()) {
			questionnaire.addForm((Form) formContext.accept(this));
		}
		return questionnaire;
	}

	@Override
	public QLNode visitForm(FormContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Identifier id = new Identifier(ctx.Identifier().getText(), pos);
		Block block = (Block) ctx.block().accept(this);
		return new Form(id, block, pos);
	}

	@Override
	public QLNode visitBlock(BlockContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Block block = new Block(pos);
		for (StatementContext statementContext : ctx.statement()) {
			block.addStatement((Statement) statementContext.accept(this));
		}
		return block;
	}

	@Override
	public QLNode visitIf(IfContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression expr = (Expression) ctx.expression().accept(this);
		Block block = (Block) ctx.ifBody.accept(this);
		return new IfStatement(expr, block, pos);
	}

	@Override
	public QLNode visitIfElse(IfElseContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression expr = (Expression) ctx.expression().accept(this);
		Block ifBlock = (Block) ctx.ifBody.accept(this);
		Block elseBlock = (Block) ctx.elseBody.accept(this);
		IfElseStatement ifElseStatement = new IfElseStatement(expr, ifBlock, elseBlock, pos);
		return ifElseStatement;
	}
	
	@Override
	public QLNode visitQuestionNormal(QuestionNormalContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Identifier id = (Identifier) ctx.questionIdentifier().accept(this);
		StrLiteral label = (StrLiteral) ctx.questionLabel().accept(this);
		Type type = (Type) ctx.questionType().accept(this);
		return new QuestionNormal(id, label, type, pos);
	}

	@Override
	public QLNode visitQuestionCompute(QuestionComputeContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Identifier id = (Identifier) ctx.questionIdentifier().accept(this);
		StrLiteral label = (StrLiteral) ctx.questionLabel().accept(this);
		Type type = (Type) ctx.questionType().accept(this);
		Expression expr = (Expression) ctx.expression().accept(this);
		return new QuestionCompute(id, label, type, expr, pos);
	}

	@Override
	public QLNode visitTypeInt(TypeIntContext ctx) {
		return new IntType();
	}

	@Override
	public QLNode visitTypeBool(TypeBoolContext ctx) {
		return new BoolType();
	}

	@Override
	public QLNode visitTypeStr(TypeStrContext ctx) {
		return new StrType();
	}

	@Override
	public QLNode visitExprNot(ExprNotContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Not(expr, pos);
	}

	@Override
	public QLNode visitExprPositive(ExprPositiveContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Positive(expr, pos);
	}

	@Override
	public QLNode visitExprNegative(ExprNegativeContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Negative(expr, pos);
	}

	@Override
	public QLNode visitExprPlus(ExprPlusContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Plus(left, right, pos);
	}

	@Override
	public QLNode visitExprMinus(ExprMinusContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Minus(left, right, pos);
	}

	@Override
	public QLNode visitExprMultiply(ExprMultiplyContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Multiply(left, right, pos);
	}

	@Override
	public QLNode visitExprDivide(ExprDivideContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Divide(left, right, pos);
	}

	@Override
	public QLNode visitExprAnd(ExprAndContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new And(left, right, pos);
	}

	@Override
	public QLNode visitExprOr(ExprOrContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Or(left, right, pos);
	}

	@Override
	public QLNode visitExprEqual(ExprEqualContext ctx) {
		
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Equal(left, right, pos);
	}

	@Override
	public QLNode visitExprNotEqual(ExprNotEqualContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new NotEqual(left, right, pos);
	}

	@Override
	public QLNode visitExprGreater(ExprGreaterContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Greater(left, right, pos);
	}

	@Override
	public QLNode visitExprGreaterEqual(ExprGreaterEqualContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new GreaterEqual(left, right, pos);
	}

	@Override
	public QLNode visitExprLess(ExprLessContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new Less(left, right, pos);
	}

	@Override
	public QLNode visitExprLessEqual(ExprLessEqualContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		Expression left = (Expression) ctx.left.accept(this);
		Expression right = (Expression) ctx.right.accept(this);
		return new LessEqual(left, right, pos);
	}

	@Override
	public QLNode visitLiteralId(LiteralIdContext ctx) {
		
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new Identifier(ctx.Identifier().getText(), pos);
	}

	@Override
	public QLNode visitLiteralInt(LiteralIntContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new IntLiteral(Integer.parseInt(ctx.getText()), pos);
	}

	@Override
	public QLNode visitLiteralBool(LiteralBoolContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new BoolLiteral(Boolean.parseBoolean(ctx.getText()), pos);
	}

	@Override
	public QLNode visitLiteralStr(LiteralStrContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new StrLiteral(ctx.StringLiteral().getText().replaceAll(DOUBLE_QUOTE_ESCAPE_PATTERN,""), pos);
	}

	@Override
	public QLNode visitExprParentheses(ExprParenthesesContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new Parenthese((Expression) ctx.expression().accept(this), pos);
	}

	@Override
	public QLNode visitQuestionIdentifier(QuestionIdentifierContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new Identifier(ctx.Identifier().getText(), pos);
	}

	@Override
	public QLNode visitQuestionLabel(QuestionLabelContext ctx) {
		CodePosition pos = CodePosition.getCodePosition(ctx);
		return new StrLiteral(ctx.StringLiteral().getText().replaceAll(DOUBLE_QUOTE_ESCAPE_PATTERN,""), pos);
	}
	
	
}
