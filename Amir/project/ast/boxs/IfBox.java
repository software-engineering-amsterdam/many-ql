package project.ast.boxs;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import project.ast.expression.Expression;
import project.ast.expression.Id;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.question.Question;
import project.main.QuestionPopulatorVisitor;
import project.typeChecking.TypeChecker;

public class IfBox implements GlobalBox {//implements IGlobalElement{//extends BoxObject{

	public List<String> cannotReferTo;
	public Expression condition;
	public List<Question> ifTrueList;
	public List<Question> elseList;
	
//	public IfBox(List<Question> questionsList) {
//		super(questionsList);
//	}

	public IfBox(Expression condition, List<Question> trueList,List<Question> falseList) {
		this.condition = condition;
		this.ifTrueList = trueList;
		this.elseList = falseList;//super(questionsList);
	}

	public Set<String> getExpressionVariables (){
		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
		this.condition.accept(variablesCollector);
		return variablesCollector.idMap.keySet();
	}
	
//	@Override
	public void addForbidenReferences(List<String> str) {
		this.cannotReferTo.addAll(str);
	}

//	@Override --> make override!
	public List<String> getForbidenReferences() {
		return this.cannotReferTo;
	}

	public void documentExpressionVariables(Map<String,String> dependenciesMap) {
		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
		this.condition.accept(variablesCollector);
		for (String string : variablesCollector.idMap.keySet()){
			for(Question question : ifTrueList){
				dependenciesMap.put(string, question.getId());		//			this.condition.accept(new ForbidReferencesVisitor(string));
			}
			for(Question question : elseList){
				dependenciesMap.put(string, question.getId());		//			this.condition.accept(new ForbidReferencesVisitor(string));
			}
		}
//		return dependenciesMap;
	}

	public void accept(QuestionPopulatorVisitor visitor) {
		visitor.visit(ifTrueList);
		visitor.visit(elseList);
	}

	public void accept(TypeChecker typeChecker){
		typeChecker.visit(this);
	}
	
	
	
//	public String getId (){
//		return id;
//	}

	public List<Question> getTrueList(){
		return this.ifTrueList;
	}

	
}

