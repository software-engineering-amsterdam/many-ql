package gui.widgets.listeners;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.GUIRender;
import gui.questions.IQuestionUI;

import java.util.Set;

import ast.expression.Expression;

public class Updater {
	private final GUIRender render;
	private final ValueRepository valueRepository;
	private final Expression expression;
	private EvaluateExpression evaluator;

	public Updater(Expression expression, GUIRender render, ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
		this.render = render;
		this.expression = expression;
		this.evaluator = new EvaluateExpression(valueRepository);
	}
	
	public void updateGUI(IQuestionUI q){
		//Value evaluateValue = this.evaluator.evaluate(expression); // get this expression from somewhere
		//todo
		//this.widgetsRepository.updateAllWidgets();
		
		//q.setValue(evaluateValue);
		Set<String> keys = valueRepository.getIDkeys();
		for ( String key : keys) {
		   System.out.println( key );
		}
		
	}
	
	public Value updatedValue(){
		Value evaluateValue = this.evaluator.evaluate(expression); 
		return evaluateValue;
	}
	
}
