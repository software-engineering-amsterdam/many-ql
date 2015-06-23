package qlProject.gui.gui_building_visitors;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class QuestionWidget {

	private JLabel label;
	private JComponent component;
	
	public QuestionWidget(JLabel label, JComponent component){
		this.label = label;
		this.component = component;
	}
	
	public JLabel getLabel(){
		return label;
	}
	
	public JComponent getComponent(){
		return component;
	}

}