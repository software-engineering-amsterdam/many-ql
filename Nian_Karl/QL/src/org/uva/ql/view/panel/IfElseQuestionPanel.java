package org.uva.ql.view.panel;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.value.Bool;
import org.uva.ql.evaluation.Evaluator;

public class IfElseQuestionPanel extends IfQuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

	private final ArrayList<Panel> elseBlockPanels;

	public IfElseQuestionPanel(ArrayList<Panel> ifBlockPanels, ArrayList<Panel> elseBlockPanels, Expression expr) {
		super(ifBlockPanels, expr);
		this.elseBlockPanels = elseBlockPanels;
		initializeBlock(this.elseBlockPanels);
	}

	public void evaluateAndShow(Evaluator evaluator) {
		// dirty
		if (evaluateExpressions(evaluator) instanceof Bool) {
			Bool value = (Bool) evaluateExpressions(evaluator);
			if (value.getValue()) {
				toggleIfBlock(true);
			} else {
				toggleIfBlock(false);
			}
		} else {
			toggleIfBlock(false);
		}
	}

	@Override
	public void toggleIfBlock(boolean show) {
		super.toggleIfBlock(show);
		if (elseBlockPanels != null) {
			for (Panel panel : elseBlockPanels) {
				panel.setVisible(!show);
			}
		}
	}

	public ArrayList<Panel> getElseBlockPanels() {
		return elseBlockPanels;
	}
}