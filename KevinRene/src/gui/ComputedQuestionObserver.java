package gui;

import java.util.Observable;
import java.util.Observer;

import cons.ql.ast.statement.ComputedQuestion;

public class ComputedQuestionObserver implements Observer {
	
	private final ComputedQuestion expression;
	private final Controller controller;
	private final Component component;
	
	public ComputedQuestionObserver(ComputedQuestion expression, Controller controller, Component component) {
		this.expression = expression;
		this.controller = controller;
		this.component = component;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		// Do something, dance or so.
	}

}
