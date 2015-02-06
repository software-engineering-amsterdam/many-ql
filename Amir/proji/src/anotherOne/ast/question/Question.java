package anotherOne.ast.question;

import java.util.List;

import javax.swing.JLabel;

import anotherOne.ast.IGlobalElement;
import anotherOne.ast.questionsVisitors.QuestionValuesVisitor;
import anotherOne.ast.questionsVisitors.QuestionsVisitor;
import anotherOne.ast.value.DefaultValueVisitor;
import anotherOne.ast.value.TypeValue;

public interface Question extends IGlobalElement {

//	public String questionId; // maybe create from the terminals also object classes!?!?
//	public String questionText;
	public TypeValue getType();
	public void setLabel(JLabel label);
	public JLabel getLabel();
	public String getId();
	public boolean isComputed();
	public <T> T accept(QuestionsVisitor<T> visitor); // {
//	public List<Object> accept (QuestionsVisitor visitor);
	public <T> T accept(DefaultValueVisitor<T> visitor);
	
}

	
