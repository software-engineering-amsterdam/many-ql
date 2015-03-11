 package gui.widgets.listeners;

import ast.expression.Expression;
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
		evaluate();
		setValueInGUI();
		setVisibilityInGUI();
	}
		
	public Value evaluate() {
		Value evaluatedValue = expression.accept(this.evaluatorVisitor);
		return evaluatedValue;
	}
	
	public void setValue(String id, Value value) {
		this.valueRepository.putID(id, value);
	}
	
	public void setValueInGUI() {
		if("true".equals(evaluate()) || "false".equals(evaluate())) {
			this.setQuestion.setVisibilityValue(evaluate());
		}
		else {
			this.setQuestion.setValue(evaluate());
		}
	}
	
	public void setVisibilityInGUI() {
		this.setQuestion.setVisibilityValue(evaluate());
	}
}
