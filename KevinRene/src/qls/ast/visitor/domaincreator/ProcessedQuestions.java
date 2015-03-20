package qls.ast.visitor.domaincreator;

import java.util.ArrayList;
import java.util.List;

import ql.gui.UIComponent;

public class ProcessedQuestions {
	private List<UIComponent> processedQuestions;
	private ProcessedQuestions parent;
	
	public ProcessedQuestions() {
		processedQuestions = new ArrayList<UIComponent>();
	}
	
	public ProcessedQuestions(ProcessedQuestions parent) {
		this();
		this.parent = parent;
	}
	
	public void addQuestion(UIComponent questionComponent) {
		processedQuestions.add(questionComponent);
	}
	
	public List<UIComponent> getProcessedQuestions() {
		return processedQuestions;
	}
	
	public ProcessedQuestions getParent() {
		if(parent == null) {
			return this;
		}
		
		return parent;
	}
}
