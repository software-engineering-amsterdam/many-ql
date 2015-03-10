package uva.ql.supporting;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.logic.*;
import uva.ql.ast.expressions.math.*;
import uva.ql.interpreter.typecheck.table.ExpressionTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;
import uva.ql.ast.expressions.literals.*;

public class ExpressionSupporting {

	private ExpressionTable expressionTable;
	private SymbolTable symbolTable;
	private Operator operator;
	private Expression right;
	private Expression left;
	
	public ExpressionSupporting(ExpressionTable _table, SymbolTable _symbolTable, Expression _left, Expression _right, Operator _operator){
		this.expressionTable = _table;
		this.symbolTable = _symbolTable;
		this.left = _left;
		this.right = _right;
		this.operator = _operator;
	}

	public Expression expressionValidator(){
		return getExpression(this.left, this.right, this.operator);
	}
	
	public Expression objectToExpression(Object object){
		return 	object.getClass().getName().equals(Identifier.class.getName()) 
				? this.convert((Identifier)object) : (Expression)object;
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
	
	public Expression convert(Identifier identifier){
		
		try{
			
			switch(this.symbolTable.retrieveValue(identifier.evaluatedValue()).getPrimitiveType()){
		
			case INT		: return this.expressionTable.keyExistsForType(identifier, IntLiteral.class.getSimpleName())
									? this.expressionTable.getExpressionOfTypeClass(identifier, PrimitiveType.findOperator("integer").getName())
									: initialiseExpression(PrimitiveType.findOperator("integer").getName());
									
			case MONEY		: return this.expressionTable.keyExistsForType(identifier, MoneyLiteral.class.getSimpleName())
									? this.expressionTable.getExpressionOfTypeClass(identifier, PrimitiveType.findOperator("money").getName())
									: initialiseExpression(PrimitiveType.findOperator("money").getName());
									
			case BOOLEAN	: return this.expressionTable.keyExistsForType(identifier, BooleanLiteral.class.getSimpleName())
									? this.expressionTable.getExpressionOfTypeClass(identifier, PrimitiveType.findOperator("boolean").getName())
									: initialiseExpression(PrimitiveType.findOperator("boolean").getName());
									
			case STRING		: return this.expressionTable.keyExistsForType(identifier, StringLiteral.class.getSimpleName())
									? this.expressionTable.getExpressionOfTypeClass(identifier, PrimitiveType.findOperator("string").getName())
									: initialiseExpression(PrimitiveType.findOperator("string").getName());
			}
		}
		catch (Exception e){
			
			throw new IllegalArgumentException("Undefined expression: " + identifier.evaluatedValue());
		}
		
		return null;
	}
	
	public Expression initialiseExpression(String object){
		
		switch(object){
			case "integer"			: return new IntLiteral(0, null);
			case "money"			: return new MoneyLiteral(0, null);
			case "boolean"			: return new BooleanLiteral(false, null);
			case "string"			: return new StringLiteral("", null);
		}
		
		return null;
	}
	
	public Expression expressionFromValue(PrimitiveType _primitiveType, String _value){
		
		if (!_value.equals("")){
			switch(_primitiveType){
				case INT			: return new IntLiteral(Integer.valueOf(_value), null);
				case MONEY			: return new MoneyLiteral(Integer.valueOf(_value), null);
				case BOOLEAN		: return new BooleanLiteral(Boolean.valueOf(_value), null);
				case STRING			: return new StringLiteral(_value, null);
			}
		}
		
		return this.initialiseExpression(_primitiveType.getName());
	}
}
