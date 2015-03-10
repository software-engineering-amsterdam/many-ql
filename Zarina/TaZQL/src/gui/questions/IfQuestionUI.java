package gui.questions;

import java.util.LinkedHashSet;

import evaluator.Value;

public class IfQuestionUI implements IQuestionUI {
	private final LinkedHashSet<IQuestionUI> ifBody;

	public IfQuestionUI() {
		this.ifBody = new LinkedHashSet<IQuestionUI>();	
	}

	public void showIfBody(IQuestionUI iQuestionUI) {
		ifBody.add(iQuestionUI);
	}

	@Override
	public void setValue(Value value) {
		// TODO Auto-generated method stub		
	}
}
