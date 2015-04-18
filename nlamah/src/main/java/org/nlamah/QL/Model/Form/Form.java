package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class Form extends DeclaringFormElement
{
	private String title;
	
	public Form(String title, ArrayList<FormElement> formElements) 
	{
		super(formElements);
		
		this.title = title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	

	@Override
	protected FormElementViewController createViewController() 
	{
		return new FormRootViewController(this);
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
