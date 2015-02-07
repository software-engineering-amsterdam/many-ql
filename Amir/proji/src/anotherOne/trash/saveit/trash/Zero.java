package anotherOne.grammar.saveit.trash;

import java.util.ArrayList;
import java.util.List;

import anotherOne.ast.BoxObject;
import anotherOne.ast.IGlobalElement;
import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.Question;
import anotherOne.ast.type.Type;
import anotherOne.grammar.qlGrammarBaseVisitor;
import anotherOne.grammar.qlGrammarParser;
import anotherOne.grammar.qlGrammarParser.AndContext;
import anotherOne.grammar.qlGrammarParser.BoolContext;
import anotherOne.grammar.qlGrammarParser.BoolTypeContext;
import anotherOne.grammar.qlGrammarParser.BoxContext;
import anotherOne.grammar.qlGrammarParser.CompleteComputedQuestionContext;
import anotherOne.grammar.qlGrammarParser.CompleteQuestionContext;
import anotherOne.grammar.qlGrammarParser.FormContext;
import anotherOne.grammar.qlGrammarParser.IdContext;
import anotherOne.grammar.qlGrammarParser.IntContext;
import anotherOne.grammar.qlGrammarParser.IntTypeContext;
import anotherOne.grammar.qlGrammarParser.NotContext;
import anotherOne.grammar.qlGrammarParser.OrContext;
import anotherOne.grammar.qlGrammarParser.ParensContext;
import anotherOne.grammar.qlGrammarParser.QuestionContext;
import anotherOne.grammar.qlGrammarParser.StrTypeContext;

public class Zero extends qlGrammarBaseVisitor<IGlobalElement>{

	@Override public IGlobalElement visitForm(qlGrammarParser.FormContext ctx) { 
		List<BoxObject> boxList = new ArrayList<BoxObject>();
		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
			boxList.add(this.visitBox(boxContext));
		}		

		return visitChildren(ctx); }

	@Override public IGlobalElement visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitOr(qlGrammarParser.OrContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitInt(qlGrammarParser.IntContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitCompare(qlGrammarParser.CompareContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitAddSub(qlGrammarParser.AddSubContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitIntType(qlGrammarParser.IntTypeContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitParens(qlGrammarParser.ParensContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitAnd(qlGrammarParser.AndContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitMulDiv(qlGrammarParser.MulDivContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitNot(qlGrammarParser.NotContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitId(qlGrammarParser.IdContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitBoolType(qlGrammarParser.BoolTypeContext ctx) { return visitChildren(ctx); }

	@Override public BoxObject visitBox(qlGrammarParser.BoxContext ctx) { 
		
		List<Question> questionsList = new ArrayList<Question>();
//		BoxObject box = new BoxObject(ctx.ID().getText(), ctx.questions());
		
		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
			questionsList.add((Question)questionContext.accept(this));
		}
		
		return new BoxObject(/*ctx.ID().getText(),*/ questionsList); }

//		return visitChildren(ctx); 
//		}

	@Override public IGlobalElement visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitStrType(qlGrammarParser.StrTypeContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitBool(qlGrammarParser.BoolContext ctx) { return visitChildren(ctx); }

	@Override public IGlobalElement visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) {
		return new BasicQuestion(ctx.ID().getText(),ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),(Type) ctx.type().accept(this)); }

//		return visitChildren(ctx); }

}
