package ast.question;

import java.util.ArrayList;

import ast.AST;

public class Form extends AST {
	private Id formId;
	private ArrayList<IQuestionVisitable> arrayQuestions;
	
	
	public Form (Id formId, ArrayList<IQuestionVisitable> arrayQuestions) {
		this.formId = formId;
		this.arrayQuestions = arrayQuestions;
	}	
	
	public Id getFormId(){
		return formId;
	}
	
	public ArrayList<IQuestionVisitable> getQuestionText(){
		return arrayQuestions;
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