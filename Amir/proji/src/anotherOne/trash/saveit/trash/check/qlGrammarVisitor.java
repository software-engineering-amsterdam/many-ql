package anotherOne.grammar.saveit.trash.check; // Generated from E:\workspace2\proji\src\anotherOne\grammar\check\qlGrammar.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface qlGrammarVisitor<T> extends ParseTreeVisitor<T> {
	T visitForm(qlGrammarParser.FormContext ctx);

	T visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx);

	T visitOr(qlGrammarParser.OrContext ctx);

	T visitInt(qlGrammarParser.IntContext ctx);

	T visitCompare(qlGrammarParser.CompareContext ctx);

	T visitAddSub(qlGrammarParser.AddSubContext ctx);

	T visitIntType(qlGrammarParser.IntTypeContext ctx);

	T visitParens(qlGrammarParser.ParensContext ctx);

	T visitAnd(qlGrammarParser.AndContext ctx);

	T visitMulDiv(qlGrammarParser.MulDivContext ctx);

	T visitNot(qlGrammarParser.NotContext ctx);

	T visitBoolType(qlGrammarParser.BoolTypeContext ctx);

	T visitBox(qlGrammarParser.BoxContext ctx);

	T visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx);

	T visitStrType(qlGrammarParser.StrTypeContext ctx);

	T visitBool(qlGrammarParser.BoolContext ctx);

	T visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx);
}