package org.uva.ql.view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.component.ExprQuestionComponent;
import org.uva.ql.view.panel.IfQuestionPanel;
import org.uva.ql.view.panel.Panel;

public class FormFrame {

	private List<IfQuestionPanel> exprPanels;
	private List<ExprQuestionComponent> exprComponents;
	private final JFrame frame;

	public FormFrame() {
		frame = new JFrame("QL Form");
		frame.setSize(500, 800);
		frame.setLayout(new MigLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.exprPanels = new ArrayList<IfQuestionPanel>();
		this.exprComponents = new ArrayList<ExprQuestionComponent>();
	}

	private void addWithConstraints(Component component) {
		frame.add(component, "wrap,push");
	}

	public void addQuestionPanel(Panel panel) {
		addWithConstraints(panel.getPanel());
	}

	public void addIfQuestionPanel(IfQuestionPanel panel) {
		addWithConstraints(panel.getPanel());
		exprPanels.add(panel);
	}

	public void addExprQuestionPanel(ExprQuestionComponent panel) {
		addWithConstraints(panel.getPanel());
		exprComponents.add(panel);
	}

	public void addDoneButton(JButton button) {
		addWithConstraints(button);
	}

	public void notifyPanels(Evaluator evaluator) {
		for (ExprQuestionComponent exprQuestionComponent : exprComponents) {
			exprQuestionComponent.evaluateAndChange(evaluator);
		}

		for (IfQuestionPanel ifQuestionPanel : exprPanels) {
			ifQuestionPanel.evaluateAndShow(evaluator);
		}
	}

	public void setFrameVisible(boolean show) {
		frame.setVisible(show);
	}
}
