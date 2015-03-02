package project.main;


import java.util.*;

import project.Tuple;
import project.ast.FormObject;
import project.ast.IGlobalElement;
import project.ast.boxs.BoxObject;
import project.ast.boxs.GlobalBox;
import project.ast.boxs.IfBox;
import project.ast.boxs.IfElseBox;
import project.ast.question.BasicQuestion;
import project.ast.question.ComputedQuestion;
import project.ast.question.Question;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class QuestionPopulatorVisitor {

	public List<Tuple> questionsInfo = new ArrayList<Tuple>();
	public List<String> labelsEnvironment = new ArrayList<String>();
	public HashMap<String, Question> questionsEnvironment = new HashMap<String,Question>();;
	public Map<String,TypeValue> TypeValueEnvironment = new HashMap<String, TypeValue>();
	public Map<String,Value> ValueEnvironment = new HashMap<String, Value>();
	public Map<String,String> dependenciesMap = new HashMap<String,String>();
	public Set<ErrorObject> errors = new HashSet<ErrorObject>();
	public HashSet<ErrorObject> errors3 = new HashSet<ErrorObject>();
	public Map<IGlobalElement,HashSet<ErrorObject>> errorri = new HashMap<IGlobalElement,HashSet<ErrorObject>>();
	public Map<String,Tuple> questionsInfo2 = new HashMap<String,Tuple>();

	public QuestionPopulatorVisitor()
	{
//        System.out.println("got until here");

	}

	public void visit(FormObject questionnaire){
		
		for (GlobalBox box : questionnaire.getBoxs()){
			box.accept(this);
		}
		
		transitiveClosureDependencies(dependenciesMap);
		questionnaire.setDependenciesMap(dependenciesMap);
	}
	
	public void visit (BoxObject box){
		for (Question question : box.questionsList){
			question.accept(this);
		}
	}

	public void visit(IfBox ifBox){
//		System.out.println("got until here");
		System.out.println("got until here");
		ifBox.documentExpressionVariables(dependenciesMap);				// dependenciesMap = should update directly
        
//		ifBox.accept(this);
		for (Question question : ifBox.ifTrueList){
			question.accept(this);
		}
		for (Question question : ifBox.elseList){
			question.accept(this);
		}

	}

	public void visit(IfElseBox ifElseBox){
//		ifElseBox.documentExpressionVariables();
		ifElseBox.accept(this);
	}

//	public void visit(List<Question> isTrueList, List<Question> isFalseList){
//		for (Question question : isTrueList){
//			question.accept(this);
//		}
//		for (Question question : isFalseList){
//			question.accept(this);
//		}
//	}
	
	public void visit(List<Question> questionsList){
		for (Question question : questionsList){
			question.accept(this);
		}
	}

	public void visit (ComputedQuestion question){
		question.documentExpressionVariables(dependenciesMap);
		updateEnvironments(question);
	}

	public void visit (BasicQuestion question){
		updateEnvironments(question);
}

//	public void visit (IfQuestion question){
//		updateEnvironments(question);// if is not a question!!!!!!
//		for (Question subQuestion : question.isTrueList){
//			subQuestion.accept(this);
//		}
//	}

	public void updateEnvironments(Question question){
		HashSet<ErrorObject> errorss = new HashSet<ErrorObject>();
		if (questionsEnvironment.containsKey(question.getId()) && ////		public void checkTypeClash(Question question){
//				true
				!(question.getType().equals(((questionsEnvironment.get(question.getId()))).getType()))
				){
					errorss.add(new ErrorObject ("type clash at: ... same question already declared as type"));
//					errorri.put(new HashSet<ErrorObject>(Arrays.asList(new ErrorObject ("type clash at: ... same question already declared as type"))));
//					question, new ErrorObject ("type clash at: ... same question already declared as type"));
					errorri.put(question,errorss);
					errors3.addAll(errorss);
//					errorri.put(question,new HashSet<ErrorObject>(Arrays.asList(new ErrorObject ("type clash at: ... same question already declared as type"))));
			}
			if (labelsEnvironment.contains(question.getQuestionText())){//question.getType().typeName() ==			//		public void checkLabelClash(Question question){ 
				errorss.add(new ErrorObject ("warning this label is already used"));
				errorri.put(question, errorss);
				errors3.addAll(errorss);
			}
		System.out.println("Questions before: " + questionsEnvironment.size());
		questionsEnvironment.put(question.getId(), question);
		System.out.println("Questions after: " + questionsEnvironment.size());
		System.out.println("Labels before: " + labelsEnvironment.size());
		labelsEnvironment.add(question.getQuestionText());
		System.out.println("Labels before: " + labelsEnvironment.size());
		System.out.println("Types before: " + TypeValueEnvironment.size());
		TypeValueEnvironment.put(question.getId(), question.getType());
		System.out.println("Types after: " + TypeValueEnvironment.size());
		questionsInfo.add(question.getQuestionsInfo());//new Tuple(question.getId(), question))
		questionsInfo2.put(question.getId(), question.getQuestionsInfo());
		
	}
	
	public void transitiveClosureDependencies(Map<String,String> dependenciesMap){
		int sizeBefore = dependenciesMap.size();
		for(String toString : dependenciesMap.values()){
			for(String fromString : dependenciesMap.keySet()){
				if (toString.equals(fromString)){
					dependenciesMap.put(toString, fromString);
				}
			}
		}
		if (dependenciesMap.size() != sizeBefore){
			transitiveClosureDependencies(dependenciesMap);
		}
	}

}