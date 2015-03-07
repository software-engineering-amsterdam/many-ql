package org.uva.ql.view.listener;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.DependentQuestionComponent;
import org.uva.ql.view.DependentQuestionPanel;

public class WidgetListener implements IWidgetListener {

	private Evaluator evaluator;
	private List<DependentQuestionPanel> dependentQuestionPanels;
	private List<DependentQuestionComponent> dependentQuestionComponents;

	public WidgetListener() {
		this.evaluator = new Evaluator();
		this.dependentQuestionPanels = new ArrayList<DependentQuestionPanel>();
		this.dependentQuestionComponents = new ArrayList<DependentQuestionComponent>();
	}

	public void initializeValue(String identifier, Value value) {
		evaluator.addValue(identifier, value);
	}

	@Override
	public void widgetValueChanged(String identifier, Value value) {
		evaluator.addValue(identifier, value);
		for (DependentQuestionPanel pannel : dependentQuestionPanels) {
			pannel.evaluateAndShow(evaluator);
		}

		for (DependentQuestionComponent pannel : dependentQuestionComponents) {
			pannel.evaluateAndChange(evaluator);
		}
	};

	public void addDependentQuestionPanel(DependentQuestionPanel panel) {
		dependentQuestionPanels.add(panel);
	}

	public void addDependentQuestionComponent(DependentQuestionComponent panel) {
		dependentQuestionComponents.add(panel);
	}
}
