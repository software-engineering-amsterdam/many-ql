package anotherOne.ast.question;

// should this be a question at all?

import java.util.List;

import javax.swing.JLabel;

import anotherOne.ast.expression.arithmeticExpr.Integ;
import anotherOne.ast.expression.booleanExpr.BiggerThanExpr;
import anotherOne.ast.expression.booleanExpr.BooleanExpression;
import anotherOne.ast.questionsVisitors.QuestionsVisitor;
import anotherOne.ast.value.DefaultValueVisitor;
import anotherOne.ast.value.TypeValue;

public class IfQuestion implements Question{
	public List<String> cannotReferTo;
	public BooleanExpression boolExpr;
	public List<Question> isTrueList;

	public IfQuestion (//String id, String question, 
		BooleanExpression boolExpr, List<Question> isTrueList){// , List<Question> isFalseList){
//		((Integ)((BiggerThanExpr)boolExpr).left).getIntValue();
		System.out.println("real check.....");
		this.boolExpr = boolExpr;
		this.isTrueList = isTrueList;
	}

	@Override
	public <T> T accept(QuestionsVisitor<T> visitor) {
//		return visitor.visit(this);
		return null;
	}

	@Override
	public TypeValue getType() {
		return null;
	}

	public List<Question> getQuestions() {
		return this.isTrueList;
	}

	@Override
	public void setLabel(JLabel label){
	}

	@Override
	public JLabel getLabel(){
		return null;
	}

	@Override
	public <T> T accept(DefaultValueVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComputed() {
		return false;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
