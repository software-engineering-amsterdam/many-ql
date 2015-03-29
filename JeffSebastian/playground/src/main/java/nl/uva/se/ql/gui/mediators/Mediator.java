package nl.uva.se.ql.gui.mediators;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;
import nl.uva.se.ql.gui.widgets.questions.calculated.BaseCalculatedQuestion;

public abstract interface Mediator {
	
	public void update(Question question, Value value);		
	public void registerCondition(ConditionBox conditionBox);
	public void registerCalculated(String identifier, BaseCalculatedQuestion baseCalculatedQuestion);
	public QuestionPane getQuestionPane();
}
