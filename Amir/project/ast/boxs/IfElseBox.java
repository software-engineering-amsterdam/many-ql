package project.ast.boxs;


import java.util.List;

import project.ast.expression.booleanExpr.BooleanExpression;
import project.ast.question.Question;
import project.main.QuestionPopulatorVisitor;

public class IfElseBox extends BoxObject{

	public BooleanExpression condition;
	public List<Question> ifTrueList;
	public List<Question> elseList;

	public IfElseBox(List<Question> questionsList) {
		super(questionsList);
	}

//	public void documentExpressionVariables() {
//		VariablesCollectionVisitor variablesCollector = new VariablesCollectionVisitor(new HashMap<String, Id>());
//		this.condition.accept(variablesCollector);
//		for (String string : variablesCollector.idMap.keySet()){
//		}
//	}

	public void accept(QuestionPopulatorVisitor visitor) {
		visitor.visit(ifTrueList);
	}
	
}
