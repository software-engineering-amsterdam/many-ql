package org.uva.ql.view.panel;

import java.util.List;

public class QuestionPanel extends Panel {

	protected final List<Panel> ifBlockPanels;

	public QuestionPanel(List<Panel> ifBlockPanels) {
		super();
		this.ifBlockPanels = ifBlockPanels;
		initializeBlock(ifBlockPanels);

	}

	public List<Panel> getPanels() {
		return ifBlockPanels;
	}

	protected void initializeBlock(List<Panel> elseBlockPanels) {
		for (Panel panel : elseBlockPanels) {
			addPanel(panel, "span, growx, hidemode 1");
		}
	}
}