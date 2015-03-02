

//hasSoldHouse "Did you SELL a house in 2014?" 
//boolean
//if (3 > 1) {
//money2 "mon2 txt" integer
//money3 "mon3 txt" integer
//}
//if (true) {
//money6 "mon2 txt" integer
//money7 "mon3 txt" integer (money2)
//}
//hasSoldHouse "Did you SELL a house in 2014?" 
//boolean
//if (hasSoldHouse2) {
//money4 "mon4 txt" integer
//money5 "mon5 txt" integer
//}
//hasBoughtHouse "Did you BUY a house in 2014?" boolean
//money1 "mon1 txt" integer
//
//

package project.grammar;

//public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor{

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.ast.FormObject;
import project.ast.IGlobalElement;
import project.ast.boxs.BoxObject;
import project.ast.boxs.GlobalBox;
import project.ast.boxs.IfBox;
import project.ast.expression.Bool;
import project.ast.expression.Expression;
import project.ast.expression.Id;
import project.ast.expression.arithmeticExpr.AdditionExpr;
import project.ast.expression.arithmeticExpr.ArithmeticExpression;
import project.ast.expression.arithmeticExpr.DivisionExpr;
import project.ast.expression.arithmeticExpr.Integ;
import project.ast.expression.arithmeticExpr.MultiplicationExpr;
import project.ast.expression.arithmeticExpr.SubtractionExpr;
import project.ast.expression.booleanExpr.AndExpr;
import project.ast.expression.booleanExpr.BiggerEqExpr;
import project.ast.expression.booleanExpr.BiggerThanExpr;
import project.ast.expression.booleanExpr.BooleanExpression;
import project.ast.expression.booleanExpr.EqualExpr;
import project.ast.expression.booleanExpr.NotExpr;
import project.ast.expression.booleanExpr.OrExpr;
import project.ast.expression.booleanExpr.SmallerEqExpr;
import project.ast.expression.booleanExpr.SmallerThanExpr;
import project.ast.expression.booleanExpr.UnequalExpr;
import project.ast.question.BasicQuestion;
import project.ast.question.ComputedQuestion;
import project.ast.question.Question;
import project.ast.question.ValueStorage;
import project.ast.value.BooleanTypeValue;
import project.ast.value.NumericalTypeValue;
import project.ast.value.StringTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.BoolValue;
import project.ast.values.IntValue;
import project.ast.values.NullValue;
import project.ast.values.StringValue;

public class QuestionnaireBuilderVisitor extends qlGrammarBaseVisitor<Object>{
	
	public Map<String, Object> map = new HashMap<String, Object>();
	public ValueStorage vlst = new ValueStorage();

	@Override public IGlobalElement visitForm(qlGrammarParser.FormContext ctx) {
//		List<Question> questionsList = new ArrayList<Question>();
////		BoxObject box = new BoxObject(ctx.ID().getText(), ctx.questions());
//		
//		for (qlGrammarParser.QuestionContext questionContext: ctx.question()){
//			questionsList.add((Question)questionContext.accept(this));
//		}
//		System.out.println("visited Box object, returning BoxObject(questionList)");
//		return new BoxObject(/*ctx.ID().getText(),*/ questionsList); }
	
	
		List<GlobalBox> boxList = new ArrayList<GlobalBox>();
//		FormObject form = new FormObject();
		for (qlGrammarParser.BoxContext boxContext: ctx.box())	{
			boxList.add((GlobalBox)boxContext.accept(this));//this.visitBox(boxContext));
		}
		return new FormObject(boxList);   //form; // (boxList);
	}

//
//	@Override public T visitOr(qlGrammarParser.OrContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitInt(qlGrammarParser.IntContext ctx) { 
		System.out.println("Visited IntLiteral			");
		System.out.println(ctx.INT().getText()); //is superclass literal really needed?
//		return new Integ(2000); } //visitChildren(ctx); }
		return new Integ(Integer.parseInt(ctx.INT().getText())); } //visitChildren(ctx); }
//		return new Int((int)(Integer.parseInt(ctx.INT().getText()))); } //visitChildren(ctx); }

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
//		IntIdExpr inn = (IntIdExpr)ctx.expr(0).accept(this);
//		System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKK"+inn.getIdString());
//		System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKK"+(((ArithmeticExpression)ctx.expr(0).accept(this)).getValue()));//.getValue());
		return new AdditionExpr((Expression)ctx.expr(0).accept(this),
				(Expression)ctx.expr(1).accept(this)); }

	@Override public IGlobalElement visitIntType(qlGrammarParser.IntTypeContext ctx) { 
		return new NumericalTypeValue();}// null;} // visitChildren(ctx); }

	public IGlobalElement visitTypeValue(BooleanTypeValue bool) { 
		return new BoolValue(false);//NumericalTypeValue();}// null;} // visitChildren(ctx); }
	}

	public IGlobalElement visitTypeValue(StringTypeValue bool) { 
		return new StringValue("");//NumericalTypeValue();}// null;} // visitChildren(ctx); }
	}

	public IGlobalElement visitTypeValue(NumericalTypeValue bool) { 
		return new IntValue(0);//NumericalTypeValue();}// null;} // visitChildren(ctx); }
	}
	//
//	@Override public T visitParens(qlGrammarParser.ParensContext ctx) { 
//		return visitChildren(ctx); }
//
//	@Override public T visitAnd(qlGrammarParser.AndContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitAnd (qlGrammarParser.AndContext ctx) {
		return new AndExpr((BooleanExpression)ctx.expr(0).accept(this),
								  (BooleanExpression)ctx.expr(1).accept(this));
	}

//	@Override public IGlobalElement visitIfBox (qlGrammarParser.ConditionalBoxContext ctx) {
//		return new AndExpr((BooleanExpression)ctx.bool_expr(0).accept(this),
//								  (BooleanExpression)ctx.bool_expr(1).accept(this));
//	}
//
//	@Override public IGlobalElement visitIfElseBox (qlGrammarParser.AndContext ctx) {
//		return new AndExpr((BooleanExpression)ctx.bool_expr(0).accept(this),
//								  (BooleanExpression)ctx.bool_expr(1).accept(this));
//	}

	@Override public IGlobalElement visitOr (qlGrammarParser.OrContext ctx) {
		return new OrExpr((BooleanExpression)ctx.expr(0).accept(this),
								  (BooleanExpression)ctx.expr(1).accept(this));
	}
	
	@Override public IGlobalElement visitNot (qlGrammarParser.NotContext ctx) {
		return new NotExpr((BooleanExpression)ctx.bool_expr());
	}
	
	@Override public IGlobalElement visitBoolId (qlGrammarParser.BoolIdContext ctx) {
		System.out.println("*****!!!!: + "+ctx.ID().getText());
		return new Id(ctx.ID().getText()); // . expr(0).accept(this),
//								  (ArithmeticExpression)ctx.expr(1).accept(this));
	}
	
	@Override public IGlobalElement visitBigger(qlGrammarParser.BiggerContext ctx) {
//		if (((Int)(ArithmeticExpression)ctx.expr(0).accept(this)).getIntValue() > ((Int)(ArithmeticExpression)ctx.expr(1).accept(this)).getIntValue()) {
		System.out.print("print::---- bigger!" );
//		}
		return new BiggerThanExpr((Expression)ctx.expr(0).accept(this),
								  (Expression)ctx.expr(1).accept(this));
	}

	@Override public IGlobalElement visitBiggerEq(qlGrammarParser.BiggerEqContext ctx) { 
		return new BiggerEqExpr((Expression)ctx.expr(0).accept(this),
				  (Expression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitUnequal(qlGrammarParser.UnequalContext ctx) { 
		return new UnequalExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (ArithmeticExpression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitEqual(qlGrammarParser.EqualContext ctx) { 
		return new EqualExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (Expression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitSmaller(qlGrammarParser.SmallerContext ctx) { 
		return new SmallerThanExpr((Expression)ctx.expr(0).accept(this),
				  (Expression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitSmallerEq(qlGrammarParser.SmallerEqContext ctx) { 
		return new SmallerEqExpr((ArithmeticExpression)ctx.expr(0).accept(this),
				  (Expression)ctx.expr(1).accept(this));
}

	@Override public IGlobalElement visitMultiply(qlGrammarParser.MultiplyContext ctx){
		System.out.println("multiplication ******");
		return new MultiplicationExpr((Expression)ctx.expr(0).accept(this),
									  (Expression)ctx.expr(0).accept(this));
	}

	@Override public IGlobalElement visitDivide(qlGrammarParser.DivideContext ctx) { 
		System.out.println("Division ////////");
		return new DivisionExpr((Expression)ctx.expr(0).accept(this),(ArithmeticExpression)ctx.expr(1).accept(this));
	}
	//((Expression)ctx.expr(0).accept(this),(Expression)ctx.expr(1).accept(this)); }//
//	@Override public T visitNot(qlGrammarParser.NotContext ctx) { 
//		return visitChildren(ctx); }
//
	@Override public IGlobalElement visitId(qlGrammarParser.IdContext ctx) { 
		System.out.println("visisted ID: "+ctx.ID().getText());
		return new Id(ctx.ID().getText()); }// new Id(ctx.ID().getText()); }

	@Override public IGlobalElement visitBoolType(qlGrammarParser.BoolTypeContext ctx) { 
//		return new BooleanTypeValue(false);}  //visitChildren(ctx); }
		return new BooleanTypeValue();}  //visitChildren(ctx); }

	@Override public BoxObject visitNormalBox(qlGrammarParser.NormalBoxContext ctx) { 
		
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
		System.out.println("Visited BoolLiteral			");
//        assert false : "BUG: unknown AddSub argument";
//        return null;
		return (new Bool(Boolean.parseBoolean(ctx.TRUE().getText())));
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

	
	@Override public IGlobalElement visitConditionalBox(qlGrammarParser.ConditionalBoxContext ctx) { 
		
		System.out.println(ctx.expr().getText());
		List<Question> isTrueList = new ArrayList<Question>();
		List<Question> isFalseList = new ArrayList<Question>();
		
		for (qlGrammarParser.QuestionContext questionContext: ctx.ifPart){
			System.out.println(((Question)questionContext.accept(this)).getId());
			isTrueList.add((Question)questionContext.accept(this));
		}
		for (qlGrammarParser.QuestionContext questionContext: ctx.elsePart){
			System.out.println(((Question)questionContext.accept(this)).getId() + "Else");
			isFalseList.add((Question)questionContext.accept(this));
		}
		return new IfBox((Expression) ctx.expr().accept(this), isTrueList, isFalseList);}

	@Override public IGlobalElement visitCompleteQuestion(qlGrammarParser.CompleteQuestionContext ctx) { 

//		vlst._values.put(ctx.ID().getText(), new BooleanValue(false));
		map.put(ctx.ID().getText(), (TypeValue) ctx.type().accept(this));//new BooleanValue(false));

		System.out.println("visited Basic Question");
		return new BasicQuestion(ctx.ID().getText(),ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),(TypeValue) ctx.type().accept(this), new NullValue()); }
//				   BasicQuestion(ctx.ID().getText(),ctx.STRING().getText(),(Type) ctx.type().accept(this)); }

	@Override public IGlobalElement visitCompleteComputedQuestion(qlGrammarParser.CompleteComputedQuestionContext ctx) { 
		map.put(ctx.ID().getText(), (TypeValue) ctx.type().accept(this));
		TypeValue type = (TypeValue) ctx.type().accept(this);
		return new ComputedQuestion(ctx.ID().getText(),
				ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
//				(TypeValue) ctx.type().accept(this), 
				type, (Expression) ctx.expr().accept(this), new NullValue());
	}
//				visitChildren(ctx); }

}
     