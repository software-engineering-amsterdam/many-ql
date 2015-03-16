package uva.ql.interpreter.typecheck;

import java.util.List;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.type.*;

public class TypeHelper {

	public static boolean expressionIsBoolean(Expression _expression){
		return TypeHelper.expressionOfType(_expression, new TypeBoolean());
	}
	
	public static boolean expressionIsInteger(Expression _expression){
		return TypeHelper.expressionOfType(_expression, new TypeInteger());
	}
	
	public static boolean expressionIsMoney(Expression _expression){
		return TypeHelper.expressionOfType(_expression, new TypeMoney());
	}
	
	public static boolean expressionIsString(Expression _expression){
		return TypeHelper.expressionOfType(_expression, new TypeString());
	}
	
	public static boolean expressionOfType(Expression _expression, Type _type){
		return _expression.evaluate().getValueType().equals(_type);
	}
	
	public static boolean checkTypeConformance(Type _type, List<Type> _supportedTypes){
		
		for (Type type : _supportedTypes){
			if (_type.equals(type)){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean expressionOfType(Expression _expression, List<Type> _supportedTypes){
		
		for (Type type : _supportedTypes){
			if (_expression.getValueType().contains(type)){
				return true;
			}
		}
		
		return false;
	}
	
}
