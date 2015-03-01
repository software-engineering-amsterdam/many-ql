package project.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.ast.boxs.GlobalBox;
import project.ast.question.Question;
public class FormObject implements IGlobalElement {

	public Map<String,String> dependenciesMap;
//	List<BoxObject> boxsList; //= new ArrayList<BoxObject>();
	List<GlobalBox> boxsList;
//	List<BoxObject> ifBoxsList;
//	List<BoxObject> elseBoxsList;
	HashMap<String, Question> questionsBank = new HashMap<String,Question>();;
	
	public FormObject (List<GlobalBox> boxs){
	boxsList = boxs;
	}
	
	public List<GlobalBox> getBoxs ()
	{
		return boxsList;
	}
//	= boxsList; 
	//	void add(BoxObject box){
//		boxsList.add(box);
//	}

	public void setDependenciesMap(Map<String, String> dependenciesMap) {
		this.dependenciesMap = dependenciesMap;
	}
	
}
