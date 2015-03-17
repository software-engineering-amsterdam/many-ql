package uva.ql.interpreter.typecheck;

import java.util.List;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.type.*;

public class TypeHelper {
	
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
			if (_expression.possibleReturnTypes().contains(type)){
				return true;
			}
		}
		
		return false;
	}
	
}
