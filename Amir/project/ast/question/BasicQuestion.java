package project.ast.question;


import java.util.List;
import java.util.Set;

import javax.swing.JLabel;

import project.Tuple;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.main.QuestionPopulatorVisitor;
import project.typeChecking.TypeChecker;

public class BasicQuestion implements Question { // possibly make this the abstract class?!

	public List<String> cannotReferTo;
	public String questionId; // maybe create from the terminals also object classes!?!?
	public String questionText;
	public TypeValue typeValue;
	public JLabel label;
	public Value value;
	public Tuple questionsContent = new Tuple(questionId, questionText,typeValue,value); 
	public Tuple questionsContent2; 

	public BasicQuestion (String id, String text, TypeValue typeValue, Value value){
		this.questionId = id;
		this.questionText = text;
		this.typeValue = typeValue;
		this.questionsContent2 = new Tuple(id, text, typeValue, value);
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

//	@Override
//	public <T> T accept(QuestionsVisitor<T> visitor) {
//		return visitor.visit(new JFrame(), this);
//	}


	@Override
	public boolean isComputed() {
		return false;
	}

	@Override
	public String getId() {
		return this.questionId;
	}

	@Override
	public void addForbidenReferences(List<String> str) {
		this.cannotReferTo.addAll(str);
	}

	@Override
	public List<String> getForbidenReferences() {
		return this.cannotReferTo;
	}

	@Override
	public Set<String> getExpressionVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuestionText() {
		return this.questionText;
	}

	@Override
	public void accept(TypeChecker typeChecker) {
		typeChecker.visit(this);
	}

	@Override
	public void accept(QuestionPopulatorVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Tuple getQuestionsInfo() {
		return this.questionsContent;
	}

	public String getId2(){
		return this.questionsContent.id;
	}
	
	public String gettext2(){
		return this.questionsContent.text;
	}
	
	public TypeValue getType2(){
		return this.questionsContent.type;
	}
	
	public Value getValue2(){
		return this.questionsContent.value;
	}
}
