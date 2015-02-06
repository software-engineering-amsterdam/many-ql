package anotherOne.ast.value;

public class Ttt {

}

package anotherOne.ast.trash;

//import qlGrammarVisit
//public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor{

import java.util.ArrayList;
import java.util.List;

import anotherOne.ast.BoxObject;
import anotherOne.ast.FormObject;
import anotherOne.ast.IGlobalElement;
import anotherOne.ast.expression.Expression;
import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.IfQuestion;
import anotherOne.ast.question.Question;
import anotherOne.ast.type.Type;
//import anotherOne.ast.type.Type;
//import anotherOne.grammar.new16.qlGrammarBaseVisitor;
//import anotherOne.grammar.new16.qlGrammarParser;
//import anotherOne.grammar.new16.qlGrammarParser.BoolContext;
//import anotherOne.grammar.new16.qlGrammarParser.BoolTypeContext;
//import anotherOne.grammar.new16.qlGrammarParser.BoxContext;
//import anotherOne.grammar.new16.qlGrammarParser.CompleteComputedQuestionContext;
//import anotherOne.grammar.new16.qlGrammarParser.CompleteQuestionContext;
//import anotherOne.grammar.new16.qlGrammarParser.FormContext;
//import anotherOne.grammar.new16.qlGrammarParser.QuestionContext;
import anotherOne.grammar.qlGrammarBaseVisitor;
import anotherOne.grammar.qlGrammarParser;

//public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor<Object>{
public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor<IGlobalElement>{
	
	@Override public IGlobalElement visitForm(qlGrammarParser.FormContext ctx) {
		
		List<BoxObject> boxList = new ArrayList<BoxObject>();
//		FormObject form = new FormObject();
		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
			boxList.add(this.visitBox(boxContext));
			System.out.print("--------");
		}		
		return new FormObject(boxList);   //form; // (boxList);
	}

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
//	@Override public IGlobalElement visitId(qlGrammarParser.IdContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public Object visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
//		return visitChildren(ctx); }

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
//	@Override public Object visitBool(qlGrammarParser.BoolContext ctx) { 
//
//		return visitChildren(ctx); }

	@Override public IGlobalElement visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { 
		
		System.out.print(ctx.condition());

		List<Question> isTrueList = new ArrayList<Question>();
		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
			isTrueList.add((Question)questionContext.accept(this));
		}

//		(ctx.ID().getText(),ctx.STRING().getText().substring
//				(1, ctx.STRING().getText().length()-1),
//				(Type) ctx.type().accept(this), 
//				(Expression) ctx.expr().accept(this));
//		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
//			questionContext.
			//			((Question)questionContext.accept(this)).;
//			questionsList.add((Question)questionContext.accept(this));
//		}

		//		List<BoxObject> boxList = new ArrayList<BoxObject>();
//		FormObject form = new FormObject();
//		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
			
//			boxList.add(this.visitBox(boxContext));
//		}		

//		System.out.print(ctx.condition());
//		System.out.print(ctx.condition());
//		System.out.print(ctx.condition());
//		System.out.print(ctx.condition());
		System.out.print("this is the condition: " + ctx.condition().getText());
//		return new IfQuestion((boolean) ctx.condition().accept(this), isTrueList, null);
		return visitChildren(ctx); 
		}
	@Override public IGlobalElement visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { 

		return new BasicQuestion(ctx.ID().getText(),ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),(Type) ctx.type().accept(this)); }
//				   BasicQuestion(ctx.ID().getText(),ctx.STRING().getText(),(Type) ctx.type().accept(this)); }

	@Override public IGlobalElement visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx) { 
		return new ComputedQuestion(ctx.ID().getText(),ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),(Type) ctx.type().accept(this), (Expression) ctx.expr().accept(this));
	}
//				visitChildren(ctx); }

}
