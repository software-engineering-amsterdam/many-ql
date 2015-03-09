package gui.widgets.listeners;

import gui.questions.SimpleQuestionUI;

import java.util.LinkedHashMap;

import ast.expression.Expression;

public class Updater {
	private final LinkedHashMap<String, SimpleQuestionUI> widgetsRepository; 
	private final EvaluateExpression evaluator;

	public Updater(LinkedHashMap<String, SimpleQuestionUI> widgetsRepository, EvaluateExpression evaluator) {
		this.widgetsRepository = widgetsRepository;
		this.evaluator = evaluator;
	}
	
	public void updateGUI(Expression expression){
		this.evaluator.evaluate(expression); // get this expression from somewhere
		//todo
		//this.widgetsRepository.updateAllWidgets();
	}
}
