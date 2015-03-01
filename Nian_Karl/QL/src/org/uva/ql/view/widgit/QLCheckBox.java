package org.uva.ql.view.widgit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.ql.view.observer.Observer;

public class QLCheckBox extends JCheckBox implements QLWidget<Boolean>, Observer{

	private static final long serialVersionUID = 1L;

	private  String identifier;
		
	public QLCheckBox() {
		CheckBoxListener checkboxListener = new CheckBoxListener();
		setOpaque(false);
		addItemListener(checkboxListener);
	}

	@Override
	public String getIdentifier() {
		return identifier;
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
	            if(e.getSource()== QLCheckBox.this){
	                if(QLCheckBox.this.isSelected()) {
	                    System.out.println("one has been selected");
	                } else {System.out.println("nothing");}
	            }
	        }
	    }

	
	
}
