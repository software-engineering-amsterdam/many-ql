package gui.trash;

import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

import ast.question.IQuestions;

public class SimpleQuestionUI extends IQuestions { 
	private final String id, label;
	private final IWidgetComponent wc;
	
	public SimpleQuestionUI(String id, String label, IWidgetComponent wc) {
		this.id = id;
		this.label = label;
		this.wc = wc;
	}

	public JLabel createdLabel() {
		JLabel id = new JLabel(label);
		return id;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public IWidgetComponent getWc() {
		return wc;
	}
	
	
}