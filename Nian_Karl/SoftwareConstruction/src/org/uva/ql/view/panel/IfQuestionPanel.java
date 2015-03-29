package org.uva.ql.view.panel;

import java.util.List;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class IfQuestionPanel extends Panel {

	private Expression expr;
	protected final List<Panel> ifBlockPanels;

	public IfQuestionPanel(List<Panel> ifBlockPanels, Expression expr) {
		super();
		this.expr = expr;
		ifBlockPanels = this.ifBlockPanels = ifBlockPanels;
		toggleIfBlock(false);
	}

	public void evaluateAndShow(Evaluator evaluator) {
		Value value = evaluator.evaluate(expr);
		if (value.isDefined()) {
			if ((boolean) value.value()) { 
				toggleIfBlock(true);
			} else {
				toggleIfBlock(false);
			}
		} else {
			toggleIfBlock(false);
		}
	}

	public List<Panel> getPanels() {
		return ifBlockPanels;
	}

	public void toggleIfBlock(boolean show) {
		for (Panel panel : this.ifBlockPanels) {
			(panel).setVisible(show);
		}
	}

	protected void initializeBlock(List<Panel> elseBlockPanels) {
		for (Panel panel : elseBlockPanels) {
			addPanel(panel, "span, growx, hidemode 1");
		}
	}
}