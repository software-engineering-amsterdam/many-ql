package org.uva.ql.view.panel;

import java.awt.Color;
import java.util.List;

public class QuestionPanel extends Panel {

	protected final List<Panel> ifBlockPanels;

	public QuestionPanel(List<Panel> ifBlockPanels) {
		super();
		this.ifBlockPanels = ifBlockPanels;
		setBackground(Color.blue);
		initializeBlock(ifBlockPanels);
	}

	public List<Panel> getPanels() {
		return ifBlockPanels;
	}

	protected void initializeBlock(List<Panel> elseBlockPanels) {
		for (Panel panel : elseBlockPanels) {
			addPanel(panel, "wrap");
		}
	}
}