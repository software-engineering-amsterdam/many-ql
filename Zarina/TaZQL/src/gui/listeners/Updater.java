package gui.listeners;

import evaluator.ValueRepository;
import gui.GUIRenderer;
import gui.questions.IQuestionUI;
import gui.questions.SimpleQuestionUI;

import java.util.Set;

import ast.expression.Expression;

public class Updater {
	private final GUIRenderer render;
	private final ValueRepository valueRepository;
	private final Expression expression;
	private EvaluateExpression evaluator = null;

	public Updater(Expression expression, GUIRenderer render, ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
		this.render = render;
		this.expression = expression;
	}
	
	public void updateGUI(IQuestionUI questionValueSetter) {
		this.evaluator = prepareEvaluator(questionValueSetter);
		
		Set<String> idKeys = valueRepository.getIDkeys();
		for ( String key : idKeys) {
		   if (!this.render.containsSimpleQuestionUI(key)) {
			  continue;
		   }
		   
		   SimpleQuestionUI simp = this.render.getIDSimpleQuestionUI(key);
		   simp.getWc().addDocListener(evaluator);
		}	
	}

	public EvaluateExpression getEvaluator() {
		return this.evaluator;
	}
	
	public EvaluateExpression prepareEvaluator(IQuestionUI questionValueSetter) {
		if(evaluator != null) {
			return this.evaluator;
		}
		return this.evaluator =  new EvaluateExpression(valueRepository, expression, questionValueSetter);
	}
}
