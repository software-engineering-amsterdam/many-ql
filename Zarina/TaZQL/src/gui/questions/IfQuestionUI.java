package gui.questions;

import evaluator.Value;
import gui.widgets.listeners.Updater;

import java.util.LinkedHashSet;

public class IfQuestionUI implements IQuestionUI,IQuestionUpdater {
	private final LinkedHashSet<IQuestionUI> ifBody;
	private final Updater updater;
	
	public IfQuestionUI(Updater updater) {
		this.ifBody = new LinkedHashSet<IQuestionUI>();	
		this.updater = updater;
	}

	public void showIfBody(IQuestionUI iQuestionUI) {
		ifBody.add(iQuestionUI);
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
