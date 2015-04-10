// Generated from E:\workspace2\qlProject\src\qlProject\grammar\qlGrammar.g4 by ANTLR 4.0
package qlProject.grammar;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class qlGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements qlGrammarVisitor<T> {
	@Override public T visitGreaterOrEq(qlGrammarParser.GreaterOrEqContext ctx) { return visitChildren(ctx); }

	@Override public T visitBasicQuestion(qlGrammarParser.BasicQuestionContext ctx) { return visitChildren(ctx); }

	@Override public T visitNegate(qlGrammarParser.NegateContext ctx) { return visitChildren(ctx); }

	@Override public T visitForm(qlGrammarParser.FormContext ctx) { return visitChildren(ctx); }

	@Override public T visitComputedQuestion(qlGrammarParser.ComputedQuestionContext ctx) { return visitChildren(ctx); }

	@Override public T visitConditionalQuestionsList(qlGrammarParser.ConditionalQuestionsListContext ctx) { return visitChildren(ctx); }

	@Override public T visitOr(qlGrammarParser.OrContext ctx) { return visitChildren(ctx); }

	@Override public T visitIntType(qlGrammarParser.IntTypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitEqual(qlGrammarParser.EqualContext ctx) { return visitChildren(ctx); }

	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { return visitChildren(ctx); }

	@Override public T visitStringLiteral(qlGrammarParser.StringLiteralContext ctx) { return visitChildren(ctx); }

	@Override public T visitConcatenationExpression(qlGrammarParser.ConcatenationExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitUnequal(qlGrammarParser.UnequalContext ctx) { return visitChildren(ctx); }

	@Override public T visitAddSubtract(qlGrammarParser.AddSubtractContext ctx) { return visitChildren(ctx); }

	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { return visitChildren(ctx); }

	@Override public T visitId(qlGrammarParser.IdContext ctx) { return visitChildren(ctx); }

	@Override public T visitNot(qlGrammarParser.NotContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessOrEq(qlGrammarParser.LessOrEqContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessThan(qlGrammarParser.LessThanContext ctx) { return visitChildren(ctx); }

	@Override public T visitMultiplyDivide(qlGrammarParser.MultiplyDivideContext ctx) { return visitChildren(ctx); }

	@Override public T visitBoolType(qlGrammarParser.BoolTypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitBoolLiteral(qlGrammarParser.BoolLiteralContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreaterThan(qlGrammarParser.GreaterThanContext ctx) { return visitChildren(ctx); }

	@Override public T visitIntLiteral(qlGrammarParser.IntLiteralContext ctx) { return visitChildren(ctx); }

	@Override public T visitStrType(qlGrammarParser.StrTypeContext ctx) { return visitChildren(ctx); }
}