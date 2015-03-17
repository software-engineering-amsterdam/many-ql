package org.uva.ql.view.panel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.MigLayout;

public class QuestionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	protected final List<Panel> ifBlockPanels;

	public QuestionPanel(List<Panel> ifBlockPanels) {
		super();
		this.ifBlockPanels = ifBlockPanels;
		setLayout(new MigLayout());
		setBackground(Color.blue);
		initializeBlock(ifBlockPanels);
	}

	public List<Panel> getPanels() {
		return ifBlockPanels;
	}

	protected void initializeBlock(List<Panel> elseBlockPanels) {
		for (Panel panel : elseBlockPanels) {
			add(panel, "wrap");
		}
	}
}