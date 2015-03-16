package org.uva.ql.view;

import org.uva.ql.evaluation.Evaluator;

public class EvaluatorSubject {
	private final Evaluator evaluator;

	public EvaluatorSubject(Evaluator evaluator) {
		super();
		this.evaluator = evaluator;
	}
	
	public Evaluator getEvaluator() {
		return evaluator;
	}

}
