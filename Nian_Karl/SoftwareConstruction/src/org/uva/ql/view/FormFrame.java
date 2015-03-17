package org.uva.ql.view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.view.component.ExprQuestionComponent;
import org.uva.ql.view.panel.IfQuestionPanel;
import org.uva.ql.view.panel.Panel;

public class FormFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private List<IfQuestionPanel> dependentQuestionPanels;
	private List<ExprQuestionComponent> dependentQuestionComponents;

	public FormFrame() {
		super("QL Form");
		setSize(500, 800);
		setLayout(new MigLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.dependentQuestionPanels = new ArrayList<IfQuestionPanel>();
		this.dependentQuestionComponents = new ArrayList<ExprQuestionComponent>();
	}

	private void addWithConstraints(Component component) {
		add(component, "wrap,push");
	}

	public void addQuestionPanel(Panel panel) {
		addWithConstraints(panel);
	}

	public void addIfQuestionPanel(IfQuestionPanel panel) {
		addWithConstraints(panel);
		dependentQuestionPanels.add(panel);
	}

	public void addExprQuestionPanel(ExprQuestionComponent panel) {
		addWithConstraints(panel);
		dependentQuestionComponents.add(panel);
	}

	public void addDoneButton(JButton button) {
		addWithConstraints(button);
	}

	public void notifyPanels(Evaluator evaluator, TypeChecker checker) {
		for (ExprQuestionComponent exprQuestionComponent : dependentQuestionComponents) {
			exprQuestionComponent.evaluateAndChange(evaluator, checker);
		}

		for (IfQuestionPanel ifQuestionPanel : dependentQuestionPanels) {
			ifQuestionPanel.evaluateAndShow(evaluator, checker);
		}
	}
}
