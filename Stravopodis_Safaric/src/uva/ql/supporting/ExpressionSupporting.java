package uva.ql.supporting;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.Literal;
import uva.ql.ast.expressions.logic.And;
import uva.ql.ast.expressions.logic.Equal;
import uva.ql.ast.expressions.logic.Greater;
import uva.ql.ast.expressions.logic.Greater_Eq;
import uva.ql.ast.expressions.logic.Less;
import uva.ql.ast.expressions.logic.Less_Eq;
import uva.ql.ast.expressions.logic.NotEqual;
import uva.ql.ast.expressions.logic.Or;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Exponentiation;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.ast.expressions.literals.*;

public class ExpressionSupporting {

	private SymbolMap symbols;
	private Expression left;
	private Expression right;
	private Operator operator;
	
	public ExpressionSupporting(SymbolMap _symbols, Expression _left, Expression _right, Operator _operator){
		this.symbols = _symbols;
		this.left = _left;
		this.right = _right;
		this.operator = _operator;
	}
	public Expression expressionValidator(){
		return getExpression(this.left, this.right, this.operator);
	}
	private Expression getExpression(Expression left, Expression right, Operator operator){
		Expression result = null;
		
		switch(operator){
		case ADD: 			{result = new Addition(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case SUB: 			{result = new Substraction(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case DIV:			{result = new Division(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case MUL:			{result = new Multiplication(this.objectToExpression(left), this.objectToExpression(right),null); break;}
		case EXP:			{result = new Exponentiation(this.objectToExpression(left),this.objectToExpression(right), null); break;}
		case LESS_EQ: 		{result = new Less_Eq(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case EQUAL:			{result = new Equal(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case AND: 			{result = new And(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case OR: 			{result = new Or(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case GREATER: 		{result = new Greater(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case LESS:			{result = new Less(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case GREATER_EQ: 	{result = new Greater_Eq(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		case NOT_EQUAL: 	{result = new NotEqual(this.objectToExpression(left), this.objectToExpression(right), null); break;}
		}
		
		return result;
	}
	private Expression objectToExpression(Object object){
		if (object instanceof Identifier){
			String identifierValue = ((Identifier)object).evaluate().getValue();
			
			Symbol questionSymbol = this.symbols.getSymbolForAttributes(identifierValue, null, Question.class.getName());
			Symbol symbol = this.symbols.getSymbolForAttributes(identifierValue, questionSymbol.getSymbolType(), Assign.class.getName());
			
			return PrimitiveType.identifierFromPrimitiveType(questionSymbol.getSymbolType(), symbolAssignmentExists(symbol, questionSymbol));
		}
		return (Expression)object;
	}
	public static Literal symbolAssignmentExists(Symbol symbol, Symbol questionSymbol){
		// If there wasn't an assignment of an expression within a question, then return the default values
		
		if (symbol == null){
			switch(questionSymbol.getSymbolType()){
				case "boolean" 	: return new BooleanLiteral(false, null);
				case "string" 	: return new StringLiteral("", null);
				case "decimal"	: return new DecimalLiteral((float)0.00, null);
				case "int"		: return new IntLiteral(0, null);
			}
		}
		
		System.err.println("Symbol: " + symbol.getClass() + " value" + symbol.getContent());
		
		return (Literal)symbol.getContent();
	}
}
