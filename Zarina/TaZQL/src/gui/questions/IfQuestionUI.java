package gui.questions;

import java.util.LinkedHashSet;

import evaluator.Value;
import gui.widgets.listeners.Updater;

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
		// TODO Auto-generated method stub		
	}

	@Override
	public void setVisibilityValue(Value value) {
		boolean visibility = Boolean.parseBoolean(value.toString());
		System.out.println("visibility " + visibility);
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
