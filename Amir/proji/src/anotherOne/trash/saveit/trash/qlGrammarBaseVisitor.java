package anotherOne.grammar.saveit.trash;
// Generated from qlGrammar.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import anotherOne.grammar.saveit.trash.qlGrammarParser.AddSubContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.AndContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.BoolContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.BoolTypeContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.BoxContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.CompareContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.CompleteComputedQuestionContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.CompleteQuestionContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.ConditionalQuestionContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.FormContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.IdContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.IntContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.IntTypeContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.MulDivContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.NotContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.OrContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.ParensContext;
import anotherOne.grammar.saveit.trash.qlGrammarParser.StrTypeContext;

public class qlGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements qlGrammarVisitor<T> {
	@Override public T visitForm(qlGrammarParser.FormContext ctx) { return visitChildren(ctx); }
			
	@Override public T visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { return visitChildren(ctx); }

	@Override public T visitOr(qlGrammarParser.OrContext ctx) { return visitChildren(ctx); }

	@Override public T visitInt(qlGrammarParser.IntContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompare(qlGrammarParser.CompareContext ctx) { return visitChildren(ctx); }

	@Override public T visitAddSub(qlGrammarParser.AddSubContext ctx) { return visitChildren(ctx); }

	@Override public T visitIntType(qlGrammarParser.IntTypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { return visitChildren(ctx); }

	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { return visitChildren(ctx); }

	@Override public T visitMulDiv(qlGrammarParser.MulDivContext ctx) { return visitChildren(ctx); }

	@Override public T visitNot(qlGrammarParser.NotContext ctx) { return visitChildren(ctx); }

	@Override public T visitId(qlGrammarParser.IdContext ctx) { return visitChildren(ctx); }

	@Override public T visitBoolType(qlGrammarParser.BoolTypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitBox(qlGrammarParser.BoxContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx) { return visitChildren(ctx); }

	@Override public T visitStrType(qlGrammarParser.StrTypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitBool(qlGrammarParser.BoolContext ctx) { return visitChildren(ctx); }

	@Override public T visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { return visitChildren(ctx); }
}