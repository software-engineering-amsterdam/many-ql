package gui.widgets;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceListener implements ItemListener   {
	private String input;
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			input = new String("Kaboom, baby");  
			System.out.print(input);
		}
		else { System.out.println("Do it!");	 }
	}
	
}