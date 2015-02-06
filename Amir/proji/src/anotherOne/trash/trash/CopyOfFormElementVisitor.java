package anotherOne.ast.trash;

import java.util.ArrayList;
import java.util.List;

import oneMore.question.Question;
import anotherOne.ast.BoxObject;
import anotherOne.ast.FormObject;
import anotherOne.grammar.saveit.trash.new17.qlGrammarBaseVisitor;
import anotherOne.grammar.saveit.trash.new17.qlGrammarParser;
public class CopyOfFormElementVisitor extends qlGrammarBaseVisitor<T>{
	
	@Override public T visitForm(qlGrammarParser.FormContext ctx) {
		
		FormObject form = new FormObject();
		for (qlGrammarParser.BoxContext tmpBox: ctx.box())	{
			FormObject.add(this.visitBox(tmpBox));
		}
		
		return form;
	}

	@Override public T visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitOr(qlGrammarParser.OrContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitInt(qlGrammarParser.IntContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitCompare(qlGrammarParser.CompareContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitAddSub(qlGrammarParser.AddSubContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitIntType(qlGrammarParser.IntTypeContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitMulDiv(qlGrammarParser.MulDivContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitNot(qlGrammarParser.NotContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitId(qlGrammarParser.IdContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitBox(qlGrammarParser.BoxContext ctx) { 
		
		List<Question> questionsList = new ArrayList<Question>();
//		BoxObject box = new BoxObject(ctx.ID().getText(), ctx.questions());
		
		for (QLParser.QuestionContext tmpQuestion: ctx.question()){
			questionsList.add(this.visitQuestion(tmpQuestion));
		}
		
		return new BoxObject(ctx.ID().getText(), questionsList); }

	@Override public T visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitStrType(qlGrammarParser.StrTypeContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitBool(qlGrammarParser.BoolContext ctx) { 
		return visitChildren(ctx); }

	@Override public T visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { 
		return visitChildren(ctx); }

}
