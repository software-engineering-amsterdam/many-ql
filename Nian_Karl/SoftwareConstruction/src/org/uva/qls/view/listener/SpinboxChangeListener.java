package org.uva.qls.view.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinboxChangeListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("Yo Spinbox changed");
	}

}
