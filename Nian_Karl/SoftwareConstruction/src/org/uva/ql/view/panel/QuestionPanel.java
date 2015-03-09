package org.uva.ql.view.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

public class QuestionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	protected final ArrayList<Panel> ifBlockPanels;
	private int gridCounterY = 0;

	public QuestionPanel(ArrayList<Panel> ifBlockPanels) {
		super();
		GridBagLayout bagLayout = new GridBagLayout();
		this.ifBlockPanels = ifBlockPanels;
		setLayout(bagLayout);
		setBackground(Color.blue);
		initializeBlock(ifBlockPanels);
	}

	public ArrayList<Panel> getPanels() {
		return ifBlockPanels;
	}

	public void addWithConstraints(Component component) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = gridCounterY;
		add(component, constraints);
		gridCounterY++;
	}

	protected void initializeBlock(ArrayList<Panel> block) {
		for (Panel panel : block) {
			addWithConstraints(panel);
		}
	}
}