package uva.qls.interpreter.gui.elements;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UILabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	private String text;
	
	public UILabel(String _text){
		this.text = _text;
		this.setLabel();
	}
	
	public String getLabelText(){
		return this.text;
	}
	
	public void setLabel(){
		this.setMinimumSize(new Dimension(300,50));
		this.setPreferredSize(new Dimension(300,50));
		this.setSize(new Dimension(300,50));
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setText(this.getLabelText());
	}
}
