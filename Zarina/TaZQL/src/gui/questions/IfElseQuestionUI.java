package gui.questions;

import evaluator.BooleanValue;
import evaluator.Value;
import gui.listeners.Updater;

import java.util.LinkedHashSet;

public class IfElseQuestionUI implements IQuestionUI,IQuestionUpdater {
	private final LinkedHashSet<IQuestionUI> ifBody, elseBody;
	private final Updater updater;
	private final String trueValue;
	private final BooleanValue setTrue, setFalse;
	
	public IfElseQuestionUI(Updater updater) {
		this.ifBody = new LinkedHashSet<IQuestionUI>();	
		this.elseBody = new LinkedHashSet<IQuestionUI>();	
		this.updater = updater;
		this.trueValue = new BooleanValue(true).toString();
		this.setTrue = new BooleanValue(true);
		this.setFalse = new BooleanValue(false);
	}

	public void showIfBody(IQuestionUI iQuestionUI) {
		ifBody.add(iQuestionUI);
	}

	public void showElseBody(IQuestionUI accept) {
		elseBody.add(accept);
	}
	
	@Override
	public void setValue(Value value) {
		assert false: "GUI Error. setValue() can't be used it if-statement questions.";
	}
	
	
	@Override
	public void setVisibilityValue(Value value) {
		for (IQuestionUI question : ifBody) {	
			question.setVisibilityValue(value);
		}
		
		for (IQuestionUI question : elseBody) {	
			if(trueValue.equals(value.toString())) {
				question.setVisibilityValue(setFalse);
			}
			else {
				question.setVisibilityValue(setTrue);
			}
		}	
	}
	
	@Override
	public Updater getUpdater() {
		return this.updater;
	}

	@Override
	public void updateGUI() {
		this.updater.updateGUI(this);
	}	
}