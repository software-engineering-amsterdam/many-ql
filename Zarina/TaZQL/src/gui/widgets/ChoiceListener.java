package gui.widgets;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceListener implements ItemListener   {
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("inserted: ");
		}
		else { System.out.println("Do it!");	 }
	}
	
}