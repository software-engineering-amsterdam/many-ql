package gui.widgets.listeners;

import evaluator.Value;
import evaluator.ValueRepository;
import gui.GUIRender;
import gui.questions.IQuestionUI;
import gui.questions.SimpleQuestionUI;

import java.util.Set;

import ast.expression.Expression;

public class Updater {
	private final GUIRender render;
	private final ValueRepository valueRepository;
	private final Expression expression;
	private EvaluateExpression_new evaluator = null;

	public Updater(Expression expression, GUIRender render, ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
		this.render = render;
		this.expression = expression;
		//this.evaluator = new EvaluateExpression_old(valueRepository, expression, null);
	}
	
	public void updateGUI(IQuestionUI q){
		//Value evaluateValue = this.evaluator.evaluate(expression); // get this expression from somewhere
		//todo
		//this.widgetsRepository.updateAllWidgets();
		this.evaluator = prepareEvaluater(q);
		//q.setValue(evaluateValue);
		this.evaluator = new EvaluateExpression_new(valueRepository, expression, q);
		System.out.println("Test" ); //+  updatedValue() );
		
		//Set<String> widgetkeys = render.getIDkeys();
		Set<String> valuekeys = valueRepository.getIDkeys();
		for ( String key : valuekeys) {
		   System.out.println( "Key: " + key );
		   if (!this.render.containsSimpleQuestionUI(key)) {
			   System.out.println("no key yet ");
			   continue;
		   }
		   
		   SimpleQuestionUI simp = this.render.getIDSimpleQuestionUI(key);
		   simp.getWc().addDocListener(evaluator);
		 //  evaluator.evaluate();
		  // updatedValue();
		}
		
		
	}
/*
	public Value updatedValue(){
		Value evaluateValue = this.evaluator.evaluate(); 
		return evaluateValue;
	}
	*/
	public EvaluateExpression_new getEvaluator() {
		return this.evaluator;
	}
	
	public EvaluateExpression_new prepareEvaluater(IQuestionUI q) {
		if(evaluator != null) {
			return this.evaluator;
		}
		return this.evaluator =  new EvaluateExpression_new(valueRepository, expression, q);
	}
}
