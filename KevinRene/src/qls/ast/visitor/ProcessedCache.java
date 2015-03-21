package qls.ast.visitor;

import java.util.ArrayList;
import java.util.List;

public class ProcessedCache<T> {
	private List<T> processedQuestions;
	private ProcessedCache<T> parent;
	
	public ProcessedCache() {
		processedQuestions = new ArrayList<T>();
	}
	
	public ProcessedCache(ProcessedCache<T> parent) {
		this();
		this.parent = parent;
	}
	
	public void addObject(T questionComponent) {
		processedQuestions.add(questionComponent);
	}
	
	public List<T> getProcessedObjects() {
		return processedQuestions;
	}
	
	public ProcessedCache<T> getParent() {
		if(parent == null) {
			return this;
		}
		
		return parent;
	}
}
