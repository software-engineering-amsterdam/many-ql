
package project.ast.question;

import java.util.List;
import java.util.Set;

import javax.swing.JLabel;

import project.Tuple;
import project.ast.IGlobalElement;
import project.ast.value.TypeValue;
import project.main.QuestionPopulatorVisitor;
import project.typeChecking.TypeChecker;

public interface Question extends IGlobalElement {

	public String getQuestionText();
	public Set<String> getExpressionVariables ();
	public void addForbidenReferences(List<String> str);
	public List<String> getForbidenReferences();
	//	public String questionId; // maybe create from the terminals also object classes!?!?
//	public String questionText;
	public TypeValue getType();
	public void setLabel(JLabel label);
	public JLabel getLabel();
	public String getId();
	public boolean isComputed();
//	public <T> T accept(QuestionsVisitor<T> visitor); // {
	public void /*??*/  accept (TypeChecker typeChecker);
	public void accept(QuestionPopulatorVisitor visitor);
	public Tuple getQuestionsInfo();
}

	
