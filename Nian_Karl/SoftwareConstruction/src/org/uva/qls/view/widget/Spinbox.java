package org.uva.qls.view.widget;

import java.util.ArrayList;

import javax.swing.JSpinner;

public class Spinbox extends JSpinner {

	private static final long serialVersionUID = 1475463795116091186L;
	public final ArrayList<Integer> spinboxValues;

	public Spinbox(ArrayList<Integer> spinboxValues) {
		super();
		this.spinboxValues = spinboxValues;
	}

}
