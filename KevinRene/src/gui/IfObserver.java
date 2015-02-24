package gui;

import java.util.Observable;
import java.util.Observer;

import cons.ql.ast.statement.If;

public class IfObserver implements Observer {
	
	private final If expression;
	private final Controller controller;
	
	public IfObserver(If expression, Controller controller) {
		this.expression = expression;
		this.controller = controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		// Do something, dance or so.
	}

}
