package nl.uva.se.ql.gui.builders;

import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.boxes.QuestionBox;

public class ConditionBuilder implements StatementVisitor{
		
	private final ConditionBox conditionBox;
	
	public ConditionBuilder(Condition condition){			
		this.conditionBox = new ConditionBox(condition);
		System.out.println(condition.getExpression().getLineNumber());
		System.out.println(condition.getExpression().getOffset());
		System.out.println(condition.getExpression());
		visit(condition);
	}

	@Override
	public void visit(Question question) {
		QuestionBox questionBox = new QuestionBox(question);
		this.conditionBox.addQuestionBox(questionBox);
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		QuestionBox questionBox = new QuestionBox((Question) calculatedQuestion);
		this.conditionBox.addQuestionBox(questionBox);		
	}

	@Override
	public void visit(Condition condition) {
		condition.visitChildren(this);		
	}
	
	public ConditionBox getConditionBox(){
		return this.conditionBox;
	}

}
