package ast.question;

import java.util.ArrayList;

import ast.type.Id;

public class Form {
	private Id formId;
	private ArrayList<SimpleQuestion> simpleQuestion;
	
	
	public Form (Id formId, ArrayList<SimpleQuestion> simpleQuestion) {
		this.formId = formId;
		this.simpleQuestion = simpleQuestion;
	}	
	
	public Id getFormId(){
		return formId;
	}
	
	public ArrayList<SimpleQuestion> getQuestionText(){
		return simpleQuestion;
	}
	
	@Override
	public String toString() {
		return "FORM { "+ formId + simpleQuestion + "}";
	}
	
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

/*
 * public class ComponentGroup<T extends JComponent> {
   private ArrayList<T> components; // For storing the components in this group.
   public void repaintAll() {
      for ( JComponent c : components )
         if (c != null)
            c.repaint();
   }
*/