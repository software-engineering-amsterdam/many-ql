package anotherOne.ast;
//package anotherOne.ast;
//
////import qlGrammarVisit
////public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor{
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import anotherOne.ast.question.BasicQuestion;
//import anotherOne.ast.question.Question;
//import anotherOne.ast.question.ValueStorage;
//import anotherOne.ast.type.BoolType;
//import anotherOne.ast.type.Type;
//import anotherOne.ast.value.Value;
////import anotherOne.ast.type.Type;
//import anotherOne.grammar.new17.qlGrammarBaseVisitor;
//import anotherOne.grammar.new17.qlGrammarParser;
//
//public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor<IGlobalElement>{
//	
//	@Override public IGlobalElement visitForm(qlGrammarParser.FormContext ctx) {
//		
//		List<BoxObject> boxList = new ArrayList<BoxObject>();
////		FormObject form = new FormObject();
//		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
//			boxList.add(this.visitBox(boxContext));
//		}		
//		return new FormObject(boxList);   //form; // (boxList);
//	}
//
////	@Override public T visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitOr(qlGrammarParser.OrContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitInt(qlGrammarParser.IntContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitCompare(qlGrammarParser.CompareContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitAddSub(qlGrammarParser.AddSubContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitIntType(qlGrammarParser.IntTypeContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitMulDiv(qlGrammarParser.MulDivContext ctx) { 
////		return visitChildren(ctx); }
////
////	@Override public T visitNot(qlGrammarParser.NotContext ctx) { 
////		return visitChildren(ctx); }
////
//	@Override public IGlobalElement visitId(qlGrammarParser.IdContext ctx) { 
//		return visitChildren(ctx); }
////
//	@Override public BoolType visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
//		System.out.print("BOOOOLEAN");
//		return new BoolType();//visitChildren(ctx); }
//	}
//	@Override public BoxObject visitBox(qlGrammarParser.BoxContext ctx) { 
//		
//		List<Question> questionsList = new ArrayList<Question>();
////		BoxObject box = new BoxObject(ctx.ID().getText(), ctx.questions());
//		
//		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
//			Question qst = (Question)questionContext.accept(this);
////			System.out.println(qst.questionId);
//			questionsList.add(qst);
////			System.out.println(questionsList.get(0).questionId); // [0];
//
//		}
//		
//		return new BoxObject(/*ctx.ID().getText(),*/ questionsList); }
//
//	
//
////	@Override public T visitStrType(qlGrammarParser.StrTypeContext ctx) { 
////		return visitChildren(ctx); }
////
//	@Override public IGlobalElement visitBool(qlGrammarParser.BoolContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public IGlobalElement visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { 
////		vlst._values.put(ctx.ID().getText(), false);
//		System.out.print("I'm here");
//		System.out.print(ctx.ID().getText());
//		return new BasicQuestion(ctx.ID().getText(),ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),(Type) ctx.type().accept(this)); }
//
//}
