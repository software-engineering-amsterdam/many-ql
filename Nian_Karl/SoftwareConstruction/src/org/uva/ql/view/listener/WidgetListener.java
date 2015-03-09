package org.uva.ql.view.listener;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.component.ExprQuestionComponent;
import org.uva.ql.view.panel.IfQuestionPanel;

public class WidgetListener implements IWidgetListener {

	private Evaluator evaluator;
	private List<IfQuestionPanel> dependentQuestionPanels;
	private List<ExprQuestionComponent> dependentQuestionComponents;

	public WidgetListener() {
		this.evaluator = new Evaluator();
		this.dependentQuestionPanels = new ArrayList<IfQuestionPanel>();
		this.dependentQuestionComponents = new ArrayList<ExprQuestionComponent>();
	}

	public void initializeValue(String identifier, Value value) {
		evaluator.addValue(identifier, value);
	}

	@Override
	public void widgetValueChanged(String identifier, Value value) {
		evaluator.addValue(identifier, value);
		for (IfQuestionPanel pannel : dependentQuestionPanels) {
			pannel.evaluateAndShow(evaluator);
		}

		for (ExprQuestionComponent pannel : dependentQuestionComponents) {
			pannel.evaluateAndChange(evaluator);
		}
	};

	public void addDependentQuestionPanel(IfQuestionPanel panel) {
		dependentQuestionPanels.add(panel);
	}

	public void addDependentQuestionComponent(ExprQuestionComponent panel) {
		dependentQuestionComponents.add(panel);
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}
}
