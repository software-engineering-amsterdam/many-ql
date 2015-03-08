package typechecker.elements;

import typechecker.TypeRepository;
import typechecker.errors.ErrorCollector;
import ast.expression.Expression;
import ast.type.Type;

public class ExpressionChecker {
	private final ErrorCollector errorCollector;
	private final TypeRepository typeRepository;
	private final Expression expression;
	
	public ExpressionChecker(ErrorCollector errorCollector, TypeRepository typeRepository, Expression expression) {
		this.errorCollector = errorCollector;
		this.typeRepository = typeRepository;
		this.expression = expression;
	}

	public void checkType(Type type) {
		if(this.expression.getExpressionType().isCompatibleToType(type)) {
			return;
		}
		
		this.errorCollector.addError("Error. Expression *" +this.expression.toString() +
									"* is of wrong type: *" + this.expression.getExpressionType() + "*, has to be *" +type + "*.");
	}
	
	

}
