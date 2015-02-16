package anotherOne.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.Pair;

import anotherOne.ast.question.Question;
import anotherOne.ast.value.TypeValue;
public class BoxObject implements IGlobalElement{
	
	public String id;
	public List<Question> questionsList = new ArrayList<Question>();
	public List<Map<Question,TypeValue>> questionValues = new ArrayList<Map<Question,TypeValue>>();
	
	public BoxObject(String id, List<Question> questionsList){
		this.id = id;
		this.questionsList = questionsList;
	}

	public BoxObject(List<Question> questionsList){
//		this.id = id;
		this.questionsList = questionsList;
	}

	
	
	
	
	public String getId (){
		return id;
	}
	public List<Question> getQuestions (){
		return this.questionsList;
	}
	
//	public Question getQuestionById (){
//		// return this.questionsList;
//	}
	
}
