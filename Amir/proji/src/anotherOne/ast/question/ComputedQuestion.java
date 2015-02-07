package anotherOne.ast.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;

import anotherOne.ast.expression.Expression;
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.arithmeticExpr.ArithmeticExpression;
import anotherOne.ast.questionsVisitors.QuestionValuesVisitor;
import anotherOne.ast.questionsVisitors.QuestionsVisitor;
//import anotherOne.ast.type.Type;
import anotherOne.ast.value.DefaultValueVisitor;
import anotherOne.ast.value.TypeValue;

public class ComputedQuestion implements Question {

	
	public List<String> cannotReferTo; 
	public String questionId; // maybe create from the terminals also object classes!?!?
	public String questionText;
	public TypeValue typeValue;
	public JLabel label;
	public ArithmeticExpression arithmeticExpr;
//	public List<Id> expinputVaribales;
	public Map<String,Id> expInputVaribales;	
	public List<String> calculationInputs;
	
//	public final boolean isComputed = true;
	
//	Boolean nool = null;
	public ComputedQuestion (String id, String question, TypeValue typeValue, ArithmeticExpression arithmeticExpr){
		this.questionId = id;
		this.questionText = question;
		this.typeValue = typeValue;
		this.arithmeticExpr = arithmeticExpr;
	}
	
	public Map<String, Id> getExpressionVariables (){
		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
		this.arithmeticExpr.accept(variablesCollector);
		return variablesCollector.idMap;
		
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
	public TypeValue getType(){
		return this.typeValue;
	}
	
	@Override
	public <T> T accept(QuestionsVisitor<T> visitor) {
		return visitor.visit(new JFrame(), this);
	}

	@Override
	public <T> T accept(DefaultValueVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isComputed() {
		return true;
	}
	
	@Override
	public String getId() {
		return this.questionId;
	}
//	public List<Object> accept (QuestionValuesVisitor visitor){
//		return visitor.visit(this);
//	}
}
