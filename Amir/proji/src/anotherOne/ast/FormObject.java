package anotherOne.ast;

import java.util.List;
public class FormObject implements IGlobalElement {

	List<BoxObject> boxsList; //= new ArrayList<BoxObject>();
	
	public FormObject (List<BoxObject> boxs){
	boxsList = boxs;
	}
	
	public List<BoxObject> getBoxs ()
	{
		return boxsList;
	}
//	= boxsList; 
	//	void add(BoxObject box){
//		boxsList.add(box);
//	}
	
	
	
}
