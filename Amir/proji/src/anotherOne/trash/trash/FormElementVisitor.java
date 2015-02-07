package anotherOne.ast.trash;

import java.util.ArrayList;
import java.util.List;

import anotherOne.ast.BoxObject;
import anotherOne.ast.FormObject;
import anotherOne.ast.IGlobalElement;
import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.Question;
import anotherOne.ast.type.Type;
//import anotherOne.ast.type.Type;
import anotherOne.grammar.saveit.trash.new17.qlGrammarBaseVisitor;
import anotherOne.grammar.saveit.trash.new17.qlGrammarParser;

public class FormElementVisitor extends qlGrammarBaseVisitor<IGlobalElement>{
	
	@Override public IGlobalElement visitForm(qlGrammarParser.FormContext ctx) {
		
		List<BoxObject> boxList = new ArrayList<BoxObject>();
//		FormObject form = new FormObject();
		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
			boxList.add(this.visitBox(boxContext));
		}		
		return new FormObject(boxList);   //form; // (boxList);
	}

//	@Override public T visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitOr(qlGrammarParser.OrContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitInt(qlGrammarParser.IntContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitCompare(qlGrammarParser.CompareContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitAddSub(qlGrammarParser.AddSubContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitIntType(qlGrammarParser.IntTypeContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitMulDiv(qlGrammarParser.MulDivContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitNot(qlGrammarParser.NotContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitId(qlGrammarParser.IdContext ctx) { 
		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
		return visitChildren(ctx); }

	@Override public BoxObject visitBox(qlGrammarParser.BoxContext ctx) { 
		
		List<Question> questionsList = new ArrayList<Question>();
//		BoxObject box = new BoxObject(ctx.ID().getText(), ctx.questions());
		
		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
			questionsList.add((Question)questionContext.accept(this));
		}
		
		return new BoxObject(/*ctx.ID().getText(),*/ questionsList); }

	

//	@Override public T visitStrType(qlGrammarParser.StrTypeContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitBool(qlGrammarParser.BoolContext ctx) { 
		return visitChildren(ctx); }

	@Override public IGlobalElement visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { 

		return new BasicQuestion(ctx.ID().getText(),ctx.STRING().getText(),(Type) ctx.type().accept(this)); }

}
