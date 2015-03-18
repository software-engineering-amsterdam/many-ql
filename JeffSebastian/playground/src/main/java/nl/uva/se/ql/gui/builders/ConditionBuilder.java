package nl.uva.se.ql.gui.builders;

import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.gui.listeners.IMediator;
import nl.uva.se.ql.gui.widgets.boxes.CalculatedBox;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.boxes.QuestionBox;

public class ConditionBuilder implements StatementVisitor{
		
	private final ConditionBox conditionBox;
	private final IMediator mediator;
	
	public ConditionBuilder(Condition condition, IMediator mediator){			
		this.conditionBox = new ConditionBox(condition);	
		this.mediator = mediator;		
		visit(condition);
	}

	@Override
	public void visit(Question question) {
		QuestionBox questionBox = new QuestionBox(question, mediator);
		this.conditionBox.addBox(questionBox);
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		CalculatedBox calculatedBox = new CalculatedBox(calculatedQuestion, mediator);	
		mediator.registerCalculated(calculatedBox);
		this.conditionBox.addBox(calculatedBox);		
	}

	@Override
	public void visit(Condition condition) {
		condition.visitChildren(this);		
	}
	
	public ConditionBox getConditionBox(){
		return this.conditionBox;
	}

}
