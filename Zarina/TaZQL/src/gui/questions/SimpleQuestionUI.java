package gui.questions;

import evaluator.Value;
import gui.GUIRender;
import gui.MainFrame;
import gui.widgets.IWidgetComponent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleQuestionUI implements IQuestionUI { 
	private final String id;
	private final JLabel label;
	private final IWidgetComponent wc;
	private Value value;
	
	public SimpleQuestionUI(String id, JLabel label, IWidgetComponent wc) {
		this.id = id;
		this.label = label;
		this.wc = wc;
	}

	public String getId() {
		return id;
	}

	public JLabel getLabel() {
		return label;
	}

	public IWidgetComponent getWc() {
		return wc;
	}

	
	@Override
	public void setValue(Value value) {
		if("true".equals(value) || "false".equals(value)) {
			boolean visibility = Boolean.parseBoolean(value.toString());
			
			this.wc.setVisible(visibility);
			this.label.setVisible(visibility);
		}	
		else {
			this.value = value;
			this.wc.setText(value);
			this.wc.setVisible(true);
		}
	}
	
	public Value getValue(){
		return this.value;
	}

	@Override
	public void setVisibilityValue(Value value) {
		if ("true".equals(value.toString()) || "false".equals(value.toString())) {
		boolean visibility = Boolean.parseBoolean(value.toString());
		
		this.wc.setVisible(visibility);
		this.label.setVisible(visibility);
		}
	}
}