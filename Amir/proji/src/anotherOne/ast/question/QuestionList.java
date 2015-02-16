package anotherOne.ast.question;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {

	public List<Question> questionList = new ArrayList<Question>();
	// refactor class is not needed
	public QuestionList (List<Question> questionList){

		this.questionList = questionList;
	}

}
