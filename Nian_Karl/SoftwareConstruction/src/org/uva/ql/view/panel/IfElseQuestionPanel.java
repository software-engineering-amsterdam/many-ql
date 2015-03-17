package org.uva.ql.view.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.uva.ql.ast.expression.Expression;

public class IfElseQuestionPanel extends IfQuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

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

	public List<Panel> getElseBlockPanels() {
		return elseBlockPanels;
	}
}