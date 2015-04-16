// Generated from E:\workspace2\qlProject\src\qlProject\grammar\qlGrammar.g4 by ANTLR 4.0
package qlProject.grammar;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface qlGrammarVisitor<T> extends ParseTreeVisitor<T> {
	T visitGreaterOrEq(qlGrammarParser.GreaterOrEqContext ctx);

	T visitBasicQuestion(qlGrammarParser.BasicQuestionContext ctx);

	T visitNegate(qlGrammarParser.NegateContext ctx);

	T visitForm(qlGrammarParser.FormContext ctx);

	T visitComputedQuestion(qlGrammarParser.ComputedQuestionContext ctx);

	T visitConditionalQuestionsList(qlGrammarParser.ConditionalQuestionsListContext ctx);

	T visitOr(qlGrammarParser.OrContext ctx);

	T visitIntType(qlGrammarParser.IntTypeContext ctx);

	T visitEqual(qlGrammarParser.EqualContext ctx);

	T visitParens(qlGrammarParser.ParensContext ctx);

	T visitStringLiteral(qlGrammarParser.StringLiteralContext ctx);

	T visitConcatenationExpression(qlGrammarParser.ConcatenationExpressionContext ctx);

	T visitUnequal(qlGrammarParser.UnequalContext ctx);

	T visitAddSubtract(qlGrammarParser.AddSubtractContext ctx);

	T visitAnd(qlGrammarParser.AndContext ctx);

	T visitId(qlGrammarParser.IdContext ctx);

	T visitNot(qlGrammarParser.NotContext ctx);

	T visitLessOrEq(qlGrammarParser.LessOrEqContext ctx);

	T visitLessThan(qlGrammarParser.LessThanContext ctx);

	T visitMultiplyDivide(qlGrammarParser.MultiplyDivideContext ctx);

	T visitBoolType(qlGrammarParser.BoolTypeContext ctx);

	T visitBoolLiteral(qlGrammarParser.BoolLiteralContext ctx);

	T visitGreaterThan(qlGrammarParser.GreaterThanContext ctx);

	T visitIntLiteral(qlGrammarParser.IntLiteralContext ctx);

	T visitStrType(qlGrammarParser.StrTypeContext ctx);
}