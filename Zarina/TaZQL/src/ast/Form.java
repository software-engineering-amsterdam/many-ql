package ast;

import java.util.ArrayList;

import ast.type.Id;

public class Form {
	private Id formId;
	private ArrayList<Question> question;
	
	
	public Form (Id formId, ArrayList<Question> question) {
		this.formId = formId;
		this.question = question;
	}	
	
	public Id getFormId(){
		return formId;
	}
	
	public ArrayList<Question> getQuestionText(){
		return question;
	}
	
	public <T> T accept(IMainVisitor<T> visitor) {
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