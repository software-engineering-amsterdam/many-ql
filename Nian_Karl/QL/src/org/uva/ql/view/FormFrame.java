package org.uva.ql.view;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.uva.ql.view.observer.Observer;
import org.uva.ql.view.observer.Subject;

public class FormFrame extends JFrame implements Subject {

	private ArrayList<Observer> observerList;
	private final String identifier;
	private static final long serialVersionUID = 1L;

	public FormFrame(String identifier) {
		super("QL Form");
		this.identifier = identifier;
		setSize(400, 600);
		setLayout(new FlowLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observerList) {
			observer.update("Hmmm");
		}
	}

	public String getIdentifier() {
		return identifier;
	}
}
