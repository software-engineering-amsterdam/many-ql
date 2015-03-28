package org.uva.ql.view.panel;

import java.util.List;

import org.uva.ql.ast.expression.Expression;

public class IfElseQuestionPanel extends IfQuestionPanel {

	private final List<Panel> elseBlockPanels;

	public IfElseQuestionPanel(List<Panel> ifBlockPanels, List<Panel> elseBlockPanels, Expression expr) {
		super(ifBlockPanels, expr);
		this.elseBlockPanels = elseBlockPanels;
		initializeBlock(this.elseBlockPanels);
	}

	@Override
	public void toggleIfBlock(boolean show) {
		super.toggleIfBlock(show);
		if (elseBlockPanels != null) {
			for (Panel panel : elseBlockPanels) {
				(panel).setVisible(!show);
			}
		}
	}
}