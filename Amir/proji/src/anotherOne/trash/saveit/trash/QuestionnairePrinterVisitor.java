package anotherOne.grammar.saveit.trash;

//import qlGrammarVisit
//public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor{

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import anotherOne.ast.BoxObject;
import anotherOne.ast.FormObject;
import anotherOne.ast.IGlobalElement;
import anotherOne.ast.expression.Bool;
import anotherOne.ast.expression.Expression;
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.arithmeticExpr.AdditionExpr;
import anotherOne.ast.expression.arithmeticExpr.ArithmeticExpression;
import anotherOne.ast.expression.arithmeticExpr.DivisionExpr;
import anotherOne.ast.expression.arithmeticExpr.Integ;
import anotherOne.ast.expression.arithmeticExpr.MultiplicationExpr;
import anotherOne.ast.expression.arithmeticExpr.SubtractionExpr;
import anotherOne.ast.expression.booleanExpr.AndExpr;
import anotherOne.ast.expression.booleanExpr.BiggerEqExpr;
import anotherOne.ast.expression.booleanExpr.BiggerThanExpr;
import anotherOne.ast.expression.booleanExpr.BoolIdExpr;
import anotherOne.ast.expression.booleanExpr.BooleanExpression;
import anotherOne.ast.expression.booleanExpr.EqualExpr;
import anotherOne.ast.expression.booleanExpr.NotExpr;
import anotherOne.ast.expression.booleanExpr.OrExpr;
import anotherOne.ast.expression.booleanExpr.SmallerEqExpr;
import anotherOne.ast.expression.booleanExpr.SmallerThanExpr;
import anotherOne.ast.expression.booleanExpr.UnequalExpr;
import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.IfQuestion;
import anotherOne.ast.question.Question;
import anotherOne.ast.question.ValueStorage;
import anotherOne.ast.type.Type;
import anotherOne.ast.value.BooleanTypeValue;
import anotherOne.ast.value.NumericalTypeValue;
import anotherOne.ast.value.StringTypeValue;
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
//import anotherOne.grammar.new17.qlGrammarBaseVisitor;
//import anotherOne.grammar.new17.qlGrammarParser;
import anotherOne.ast.value.TypeValue;
import anotherOne.grammar.qlGrammarParser;
import anotherOne.grammar.qlGrammarParser.AddContext;
import anotherOne.grammar.qlGrammarParser.AndContext;
import anotherOne.grammar.qlGrammarParser.BiggerContext;
import anotherOne.grammar.qlGrammarParser.BiggerEqContext;
import anotherOne.grammar.qlGrammarParser.BolexpContext;
import anotherOne.grammar.qlGrammarParser.BoolContext;
import anotherOne.grammar.qlGrammarParser.BoolIdContext;
import anotherOne.grammar.qlGrammarParser.BoolTypeContext;
import anotherOne.grammar.qlGrammarParser.BoxContext;
import anotherOne.grammar.qlGrammarParser.CompleteComputedQuestionContext;
import anotherOne.grammar.qlGrammarParser.CompleteQuestionContext;
import anotherOne.grammar.qlGrammarParser.DivideContext;
import anotherOne.grammar.qlGrammarParser.EqualContext;
import anotherOne.grammar.qlGrammarParser.FormContext;
import anotherOne.grammar.qlGrammarParser.IdContext;
import anotherOne.grammar.qlGrammarParser.IntContext;
import anotherOne.grammar.qlGrammarParser.IntTypeContext;
import anotherOne.grammar.qlGrammarParser.MultiplyContext;
import anotherOne.grammar.qlGrammarParser.NotContext;
import anotherOne.grammar.qlGrammarParser.OrContext;
import anotherOne.grammar.qlGrammarParser.QuestionContext;
import anotherOne.grammar.qlGrammarParser.SmallerContext;
import anotherOne.grammar.qlGrammarParser.SmallerEqContext;
import anotherOne.grammar.qlGrammarParser.StrTypeContext;
import anotherOne.grammar.qlGrammarParser.SubContext;
import anotherOne.grammar.qlGrammarParser.UnequalContext;

public class QuestionnairePrinterVisitor {
	
	public HashMap hm = new HashMap();
	public Map<String, Object> map = new HashMap();
	Map mp = new HashMap<String,TypeValue>();
	public ValueStorage vlst = new ValueStorage();

	public void visitForm(qlGrammarParser.FormContext ctx) {
		
		List<BoxObject> boxList = new ArrayList<BoxObject>();
//		FormObject form = new FormObject();
		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
			boxList.add(this.visitBox(boxContext));
		}
		System.out.println("visited Form object, returning FormObject(boxList)");
	}

//
//	@Override public T visitOr(qlGrammarParser.OrContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitInt(qlGrammarParser.IntContext ctx) { 
		System.out.println("OK!			");
		System.out.println(ctx.INT().getText());
		return new Integ(Integer.parseInt(ctx.INT().getText())); } //visitChildren(ctx); }

//	System.out.println("lets try and see this: ");
//	System.out.println(ctx.ID().getText());
//	return new Id(ctx.ID().getText()); }

	
	//
//	@Override public Object visitCompare(qlGrammarParser.CompareContext ctx) { 
//		
////		return null ; 
//		return false;
//	}
//		return visitChildren(ctx); }
//
//	@Override public IGlobalElement visitAdd(qlGrammarParser.AddContext ctx) { 
////		return new AdditionExpr(new Int(0),new Int(0));
//		//return visitChildren(ctx);//
//		new AdditionExpr((ArithmeticExpression2)ctx.expr(0).accept(this),(ArithmeticExpression2)ctx.expr(1).accept(this)); }

	@Override public IGlobalElement visitSub(qlGrammarParser.SubContext ctx) { 
		System.out.println("subtraction -----");
		return new SubtractionExpr((ArithmeticExpression)ctx.expr(0).accept(this),(ArithmeticExpression)ctx.expr(1).accept(this)); }

	@Override public IGlobalElement visitAdd(qlGrammarParser.AddContext ctx) { 
		System.out.println("addition +++++");
		return new AdditionExpr((ArithmeticExpression)ctx.expr(0).accept(this),(ArithmeticExpression)ctx.expr(1).accept(this)); }

	@Override public IGlobalElement visitIntType(qlGrammarParser.IntTypeContext ctx) { 
		return new NumericalTypeValue();}// null;} // visitChildren(ctx); }
//
//	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitAnd (qlGrammarParser.AndContext ctx) {
		return new AndExpr((BooleanExpression)ctx.bool_expr(0).accept(this),
								  (BooleanExpression)ctx.bool_expr(1).accept(this));
	}
	
	@Override public IGlobalElement visitOr (qlGrammarParser.OrContext ctx) {
		return new OrExpr((BooleanExpression)ctx.bool_expr(0).accept(this),
								  (BooleanExpression)ctx.bool_expr(1).accept(this));
	}
	
	@Override public IGlobalElement visitNot (qlGrammarParser.NotContext ctx) {
		return new NotExpr((BooleanExpression)ctx.bool_expr());
	}
	
	@Override public IGlobalElement visitBoolId (qlGrammarParser.BoolIdContext ctx) {
		return new BoolIdExpr(ctx.ID().getText()); // . expr(0).accept(this),
//								  (ArithmeticExpression)ctx.expr(1).accept(this));
	}
	
	@Override public IGlobalElement visitBigger(qlGrammarParser.BiggerContext ctx) {
		return new BiggerThanExpr((ArithmeticExpression)ctx.expr(0).accept(this),
								  (ArithmeticExpression)ctx.expr(1).accept(this));
	}

	@Override public IGlobalElement visitBiggerEq(qlGrammarParser.BiggerEqContext ctx) { 
		return new BiggerEqExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (ArithmeticExpression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitUnequal(qlGrammarParser.UnequalContext ctx) { 
		return new UnequalExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (ArithmeticExpression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitEqual(qlGrammarParser.EqualContext ctx) { 
		return new EqualExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (ArithmeticExpression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitSmaller(qlGrammarParser.SmallerContext ctx) { 
		return new SmallerThanExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (ArithmeticExpression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitSmallerEq(qlGrammarParser.SmallerEqContext ctx) { 
		return new SmallerEqExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (ArithmeticExpression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitMultiply(qlGrammarParser.MultiplyContext ctx){
		System.out.println("multiplication ******");
		return new MultiplicationExpr((ArithmeticExpression)ctx.expr(0).accept(this),
									  (ArithmeticExpression)ctx.expr(0).accept(this));
	}

	@Override public IGlobalElement visitDivide(qlGrammarParser.DivideContext ctx) { 
		System.out.println("Division ////////");
		return new DivisionExpr((ArithmeticExpression)ctx.expr(0).accept(this),(ArithmeticExpression)ctx.expr(1).accept(this));
	}
	//((Expression)ctx.expr(0).accept(this),(Expression)ctx.expr(1).accept(this)); }//
//	@Override public T visitNot(qlGrammarParser.NotContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitId(qlGrammarParser.IdContext ctx) { 
		
		System.out.println("lets try and see this: ");
		System.out.println(ctx.ID().getText());
//		String txt = ctx.ID().getText();
//		Id idi = new Id(txt);
//		System.out.println(txt);
		return new Id(ctx.ID().getText()); }// new Id(ctx.ID().getText()); }

	@Override public IGlobalElement visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
//		return new BooleanTypeValue(false);}  //visitChildren(ctx); }
		return new BooleanTypeValue();}  //visitChildren(ctx); }

	@Override public BoxObject visitBox(qlGrammarParser.BoxContext ctx) { 
		
		List<Question> questionsList = new ArrayList<Question>();
//		BoxObject box = new BoxObject(ctx.ID().getText(), ctx.questions());
		
		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
			questionsList.add((Question)questionContext.accept(this));
		}
		System.out.println("visited Box object, returning BoxObject(questionList)");
		return new BoxObject(/*ctx.ID().getText(),*/ questionsList); }


	@Override public IGlobalElement visitStrType(qlGrammarParser.StrTypeContext ctx) { 
		return new StringTypeValue("");} //visitChildren(ctx); }
//
	@Override public IGlobalElement visitBool(qlGrammarParser.BoolContext ctx) { 
//				to null or not to null? if not - some condition to start computation
//        if ( null != ctx.TRUE()) // MUL() ) // maybe change this to normal like Boolean.valueOf(ctx.getText())
//        {
//            return new Bool(true); //  MulExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
//                                   //   (Expression) ctx.expr().get( 1 ).accept( this ) );
//        }
//        if ( null != ctx.FALSE() )
//        {
//        	return new Bool(true);
//        }
        
        assert false : "BUG: unknown AddSub argument";
        return null;
		}
        
//        	return new DivExpression( (Expression) ctx.expr().get( 0 ).accept( this ),
//                                      (Expression) ctx.expr().get( 1 ).accept( this ) );

//		return Boolean.valueOf( ctx...getText() );
//		}
//		return visitChildren(ctx); }

//	@Override public IGlobalElement visitConditionalQuestion(qlGrammarParser.ConditionalQuestionContext ctx) { 
//		System.out.println("stop and get a second life");
		
//		System.out.print(ctx.condition());
//		List<Question> isTrueList = new ArrayList<Question>();
//		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
//			System.out.println(((Question)questionContext.accept(this)).getId());
//			isTrueList.add((Question)questionContext.accept(this));
//		}
//
//		System.out.print(ctx.condition());
////		return new ConditionalQuestion(ctx.condition().g)
//		System.out.print("this is the condition: " + ctx.condition().getText());
//		return new IfQuestion((BooleanExpression) ctx.condition().accept(this), isTrueList);}
//		return (IGlobalElement)visitChildren(ctx); }

	
	@Override public IGlobalElement visitBolexp(qlGrammarParser.BolexpContext ctx) { 
		
		System.out.println("stop and get a life");
		System.out.println(ctx.bool_expr());
		System.out.println(ctx.bool_expr().getText());
		List<Question> isTrueList = new ArrayList<Question>();
		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
			System.out.println(((Question)questionContext.accept(this)).getId());
			isTrueList.add((Question)questionContext.accept(this));
		}

		System.out.print(ctx.bool_expr());
//		return new ConditionalQuestion(ctx.condition().g)
		System.out.print("this is the condition: " + ctx.bool_expr().getText());
		return new IfQuestion((BooleanExpression) ctx.bool_expr().accept(this), isTrueList);}
//		return visitChildren(ctx); }

	@Override public IGlobalElement visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { 

//		vlst._values.put(ctx.ID().getText(), new BooleanValue(false));
		map.put(ctx.ID().getText(), (TypeValue) ctx.type().accept(this));//new BooleanValue(false));
		System.out.println("visited Basic Question, returning ID, Test and Value");
		return new BasicQuestion(ctx.ID().getText(),ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),(TypeValue) ctx.type().accept(this)); }
//				   BasicQuestion(ctx.ID().getText(),ctx.STRING().getText(),(Type) ctx.type().accept(this)); }

	@Override public IGlobalElement visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx) { 
		map.put(ctx.ID().getText(), (TypeValue) ctx.type().accept(this));
		return new ComputedQuestion(ctx.ID().getText(),
				ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
				(TypeValue) ctx.type().accept(this), 
				(ArithmeticExpression) ctx.expr().accept(this));
	}
//				visitChildren(ctx); }

}
     