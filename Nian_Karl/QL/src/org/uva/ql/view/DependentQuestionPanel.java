package org.uva.ql.view;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.widgit.QLWidget;

public class DependentQuestionPanel extends QuestionPanel {
 
	private static final long serialVersionUID = -4507161988032536469L;

	private Expression expr;
	
	public DependentQuestionPanel(QuestionNormal question, QLWidget<?> widget,Expression expr) {
		super(question, widget);
		this.expr = expr;
	}
	

}
