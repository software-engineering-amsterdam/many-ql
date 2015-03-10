 package tests.evaluator;

import evaluator.EvaluatorVisitor;
import evaluator.Value;
import evaluator.ValueRepository;
import ast.expression.Expression;

public class TestEvaluateExpression {

	private ValueRepository valueRepository;
	private final EvaluatorVisitor evaluatorVisitor;
	
	public TestEvaluateExpression(ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
		this.evaluatorVisitor = new EvaluatorVisitor(this.valueRepository);
	}
		
	public Value evaluate(Expression expression) {
		return expression.accept(this.evaluatorVisitor);
	}
	
	public void setValue(String id, Value value) {
		this.valueRepository.putID(id, value);
	}
	
	
	
}
