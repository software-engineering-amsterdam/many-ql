 package gui.listeners;

import ast.expression.Expression;
import evaluator.BooleanValue;
import evaluator.EvaluatorVisitor;
import evaluator.Value;
import evaluator.ValueRepository;
import gui.questions.IQuestionUI;

public class EvaluateExpression {

	private ValueRepository valueRepository;
	private final EvaluatorVisitor evaluatorVisitor;
	private final Expression expression;
	private final IQuestionUI setQuestion;
	
	public EvaluateExpression(ValueRepository valueRepository, Expression expression, IQuestionUI setQuestion) {
		this.valueRepository = valueRepository;
		this.expression = expression;
		this.evaluatorVisitor = new EvaluatorVisitor(this.valueRepository);
		this.setQuestion = setQuestion;
		setValueInGUI();
	}
		
	public Value evaluate() {
		Value evaluatedValue = expression.accept(this.evaluatorVisitor);
		return evaluatedValue;
	}
	
	public void setValue(String id, Value value) {
		this.valueRepository.putValue(id, value);
	}
	
	public void setValueInGUI() { 
		String insertedValue = evaluate().toString();
		String regexDigits ="[-+]?\\d+(\\.\\d+)?";
		
		if (!insertedValue.isEmpty() && insertedValue.matches(regexDigits)) {
			this.setQuestion.setValue(evaluate());
		}
		
		String trueValue = new BooleanValue(true).toString();
		String falseValue = new BooleanValue(false).toString();
		
		if (trueValue.equals(insertedValue) || falseValue.equals(insertedValue)) {
			this.setQuestion.setVisibilityValue(evaluate());
		}
		
	}
}
