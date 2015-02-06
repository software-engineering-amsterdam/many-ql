package anotherOne.ast.question;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import anotherOne.ast.questionsVisitors.QuestionsVisitor;
import anotherOne.ast.value.DefaultValueVisitor;
import anotherOne.ast.value.TypeValue;
public class BasicQuestion implements Question { // possibly make this the abstract class?!

	public List<String> cannotReferTo;
	public String questionId; // maybe create from the terminals also object classes!?!?
	public String questionText;
	public TypeValue typeValue;
	public JLabel label;
	
	public BasicQuestion (String id, String question, TypeValue typeValue){
		this.questionId = id;
		this.questionText = question;
		this.typeValue = typeValue;
	}
	
	@Override
	public TypeValue getType(){
		return this.typeValue;
	}

	@Override
	public void setLabel(JLabel label){
		this.label = label;
	}

	@Override
	public JLabel getLabel(){
		return this.label;
	}

	@Override
	public <T> T accept(QuestionsVisitor<T> visitor) {
		return visitor.visit(new JFrame(), this);
	}

	@Override
	public <T> T accept(DefaultValueVisitor<T> visitor) {
		// TODO Auto-generated method stub   // necessary?
		return null;
	}

	@Override
	public boolean isComputed() {
		return false;
	}

	@Override
	public String getId() {
		return this.questionId;
	}
	
}
