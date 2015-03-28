package gui.questions;

import gui.listeners.Updater;
import gui.widgets.IWidgetComponent;

import javax.swing.JLabel;

public class ComputedQuestionUI extends SimpleQuestionUI implements IQuestionUpdater { 
	private Updater updater;
	
	public ComputedQuestionUI(String id, JLabel label, IWidgetComponent wc, Updater updater) {
		super(id, label, wc); 
		this.getWc().setEnabled(false); 
		this.updater = updater;
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