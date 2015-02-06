// Generated from E:\workspace2\proji\src\anotherOne\grammar\qlGrammar.g4 by ANTLR 4.0
package anotherOne.grammar;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface qlGrammarVisitor<T> extends ParseTreeVisitor<T> {
	T visitBigger(qlGrammarParser.BiggerContext ctx);

	T visitBiggerEq(qlGrammarParser.BiggerEqContext ctx);

	T visitIntType(qlGrammarParser.IntTypeContext ctx);

	T visitUnequal(qlGrammarParser.UnequalContext ctx);

	T visitSmaller(qlGrammarParser.SmallerContext ctx);

	T visitMultiply(qlGrammarParser.MultiplyContext ctx);

	T visitId(qlGrammarParser.IdContext ctx);

	T visitFalse(qlGrammarParser.FalseContext ctx);

	T visitAdd(qlGrammarParser.AddContext ctx);

	T visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx);

	T visitStrType(qlGrammarParser.StrTypeContext ctx);

	T visitDivide(qlGrammarParser.DivideContext ctx);

	T visitSub(qlGrammarParser.SubContext ctx);

	T visitForm(qlGrammarParser.FormContext ctx);

	T visitOr(qlGrammarParser.OrContext ctx);

	T visitInt(qlGrammarParser.IntContext ctx);

	T visitTrue(qlGrammarParser.TrueContext ctx);

	T visitParens(qlGrammarParser.ParensContext ctx);

	T visitEqual(qlGrammarParser.EqualContext ctx);

	T visitAnd(qlGrammarParser.AndContext ctx);

	T visitNot(qlGrammarParser.NotContext ctx);

	T visitSmallerEq(qlGrammarParser.SmallerEqContext ctx);

	T visitBoolType(qlGrammarParser.BoolTypeContext ctx);

	T visitBoolId(qlGrammarParser.BoolIdContext ctx);

	T visitBox(qlGrammarParser.BoxContext ctx);

	T visitBool(qlGrammarParser.BoolContext ctx);

	T visitBolexp(qlGrammarParser.BolexpContext ctx);

	T visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx);
}