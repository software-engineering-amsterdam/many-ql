package org.fugazi.gui.event_listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UIBoolQuestionListener implements ItemListener {
    
    public void itemStateChanged(ItemEvent e) {
        
        if (e.getStateChange() == ItemEvent.DESELECTED)
            System.out.println("Deselected");
        
        if (e.getStateChange() == ItemEvent.SELECTED)
            System.out.println("Selected");
    }
}
