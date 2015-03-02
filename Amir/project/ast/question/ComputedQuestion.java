package project.ast.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;

import project.Tuple;
import project.ast.expression.Expression;
import project.ast.expression.Id;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.main.QuestionPopulatorVisitor;
import project.typeChecking.TypeChecker;

public class ComputedQuestion implements Question {


	public List<String> cannotReferTo; 
	public String questionId; // maybe create from the terminals also object classes!?!?
	public String questionText;
	public TypeValue typeValue;
	public Value value;
	public JLabel label;
	public Expression expr;
	//	public List<Id> expinputVaribales;
	public Map<String,Id> expInputVaribales;	
	public List<String> calculationInputs;
	public Tuple questionsContent = new Tuple(questionId, questionText,typeValue,value); 
	public Tuple questionsContent2; 

	//	public final boolean isComputed = true;

	public ComputedQuestion (String id, String text, TypeValue typeValue, Expression expression, Value value){
		this.questionId = id;
		this.questionText = text;
		this.typeValue = typeValue;
		this.expr = expression;
		this.questionsContent2 = new Tuple(id, text, typeValue, value);
	}
	
	public Set<String> getExpressionVariables (){
		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
		this.expr.accept(variablesCollector);
		return variablesCollector.idMap.keySet();
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

//	@Override
//	public <T> T accept(QuestionsVisitor<T> visitor) {
//		return visitor.visit(new JFrame(), this);
//	}

	@Override
	public boolean isComputed() {
		return true;
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
	public String getQuestionText() {
		return this.questionText;
	}

	@Override
	public Tuple getQuestionsInfo() {
		return this.questionsContent;
	}

	public String getId2(){
		return this.questionsContent.id;
	}
	
	public String getText2(){
		return this.questionsContent.text;
	}
	
	public TypeValue getType2(){
		return this.questionsContent.type;
	}
	
	public Value getValue2(){
		return this.questionsContent.value;
	}
	@Override
	public void accept(TypeChecker typeChecker) {
		typeChecker.visit(this);
	}
	//	public List<Object> accept (QuestionValuesVisitor visitor){
	//		return visitor.visit(this);
	//	}

	@Override
	public void accept(QuestionPopulatorVisitor visitor) {
		visitor.visit(this);
	}

	public Map<String, String> documentExpressionVariables(Map<String, String> dependenciesMap) {
		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
		this.expr.accept(variablesCollector);
		for (String string : variablesCollector.idMap.keySet()){
			dependenciesMap.put(string, this.getId());		//			this.condition.accept(new ForbidReferencesVisitor(string));
		}
		return dependenciesMap;
		//		this.arithmeticExpr.accept(new ForbidReferencesVisitor(this.questionId));
		}
	}
