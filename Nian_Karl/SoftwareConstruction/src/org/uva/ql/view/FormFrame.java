package org.uva.ql.view;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.component.ExprQuestionItem;
import org.uva.ql.view.panel.IfQuestionPanel;
import org.uva.ql.view.panel.Panel;

public class FormFrame {

	private List<IfQuestionPanel> exprPanels;
	private List<ExprQuestionItem> exprItems;
	private final JFrame frame;

	public FormFrame() {
		frame = new JFrame("QL Form");
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setLayout(new MigLayout("", "[grow, push, fill]", ""));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.exprPanels = new ArrayList<IfQuestionPanel>();
		this.exprItems = new ArrayList<ExprQuestionItem>();
	}

	private void addWithConstraints(Component component) {
		frame.add(component, "span,growx, hidemode 1");
		frame.pack();
	}

	public void addQuestionPanel(Panel panel) {
		addWithConstraints(panel.getPanel());
	}

	public void addIfQuestionPanel(IfQuestionPanel panel) {
		addWithConstraints(panel.getPanel());
		exprPanels.add(panel);
	}

	public void addExprQuestionItem(ExprQuestionItem panel) {
		addWithConstraints(panel.getPanel());
		exprItems.add(panel);
	}

	public void addDoneButton(JButton button) {
		addWithConstraints(button);
	}

	public void notifyPanels(Evaluator evaluator, Identifier identifier) {
		for (ExprQuestionItem item : exprItems) {
			// This if statement is there to prevent it from updating itself.
			if (!item.getIdentifier().equals(identifier)) {
				item.evaluateAndChange(evaluator);
			}
		}

		for (IfQuestionPanel panel : exprPanels) {
			panel.evaluateAndShow(evaluator);
		}
		frame.pack();
	}

	public void setFrameVisible(boolean show) {
		frame.setVisible(show);
	}
}
