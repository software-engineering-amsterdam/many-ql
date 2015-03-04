package gui.widgets.listeners;

import evaluator.EvaluatorVisitor;
import evaluator.Value;
import evaluator.ValueRepository;
import ast.expression.Expression;

public class EvaluateExpression {

	private ValueRepository valueRepository;
	private final EvaluatorVisitor evaluatorVisitor;
	
	public EvaluateExpression(ValueRepository valueRepository) {
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
