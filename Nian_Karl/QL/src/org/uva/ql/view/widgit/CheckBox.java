package org.uva.ql.view.widgit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.ql.view.observer.Observer;

public class CheckBox extends JCheckBox implements Widget<Boolean>, Observer{

	private static final long serialVersionUID = 1L;

	public CheckBox() {
		CheckBoxListener checkboxListener = new CheckBoxListener();
		setOpaque(false);
		addItemListener(checkboxListener);
	}

	@Override
	public Boolean getValue() {
		return getValue();
	}

	@Override
	public void update(Object object) {
		
	}
	
	  private class CheckBoxListener implements ItemListener{
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getSource()== CheckBox.this){
	                if(CheckBox.this.isSelected()) {
	                    System.out.println("one has been selected");
	                } else {System.out.println("nothing");}
	            }
	        }
	    }

	
	
}
