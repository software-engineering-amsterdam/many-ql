package nl.uva.se.visitor;

import nl.uva.se.gui.elements.ConditionBox;
import nl.uva.se.gui.elements.QuestionBox;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;

public class ConditionVisitor implements StatementVisitor{
		
	private final ConditionBox conditionBox;
	
	public ConditionVisitor(Condition condition){			
		this.conditionBox = new ConditionBox(condition);
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
