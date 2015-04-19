package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Error.QLError;
import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class Form extends DeclaringFormElement
{
	public ArrayList<IdentifierLiteral> referencedQuestions;
	
	private String title;
	private ArrayList<QLError> errors;
	
	public Form(String title, ArrayList<FormElement> formElements) 
	{
		super(formElements);
		
		this.title = title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void addError(QLError error)
	{
		if (!Helper.arrayExistsAndHasElements(errors))
		{
			errors = new ArrayList<QLError>();
		}
		
		errors.add(error);
	}
	
	public ArrayList<QLError> errors()
	{
		return errors;
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	 @Override 
	 public boolean equals(Object object) 
	 {
		 if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof Form))
		 {
			 return false;
		 }
		 
		 Form value = (Form)object;
		 
		 if (!(this.title.equals(value.title)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
