package uva.ql.interpreter.gui.elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class UICheckBox extends JCheckBox {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public UICheckBox() {
		this.setText("Yes");
		this.setSelected(false);
		this.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        
		        if (isSelected()) {
		            System.err.println("Check box selected");
		        } else {
		        	System.err.println("Check box de-selected");
		        }
		    }
		});
		
	}
	public UICheckBox(Boolean _value) {
		this.setText("Yes");
		this.setSelected(_value);
		
	}
	
	public void setCheckBox(Boolean _status) {
		
		this.setSelected(_status);
	}
	
	public Boolean getCheckBox(){
		
		return this.isSelected();
	}

}
