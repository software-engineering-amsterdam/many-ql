package gui.observer;

import gui.Widget;

import java.util.Observable;
import java.util.Observer;

public class QuestionObserver implements Observer {
	private Widget subject;
	
	public QuestionObserver() {
		this.subject = null;
	}
	
	public void setSubject(Widget subject) {
		this.subject = subject;
	}

	@Override
	public void update(Observable changedSubject, Object argument) {
		if(changedSubject == subject) {
			System.out.println("Changed subject.");
		}
	}
}