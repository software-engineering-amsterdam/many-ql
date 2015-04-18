package org.nlamah.QL.Model.Form.Abstract;

import java.util.ArrayList;

import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;

public abstract class FormElement extends QLNode
{	
	private IdentifierLiteral identifier;
	private FormElementViewController viewController;

	private ArrayList<FormElement> relatedElements;
	
	public FormElement(IdentifierLiteral identifier)
	{
		super();
		
		this.identifier = identifier;
		
		if (identifier != null)
		{
			identifier.setParentNode(this);
		}
		
		relatedElements = new ArrayList<FormElement>();
	}
	
	public IdentifierLiteral identifier()
	{
		return this.identifier;
	}
	
	public ArrayList<FormElement> relatedElements()
	{
		return this.relatedElements;
	}
	
	public void addRelatedElement(FormElement relatedElement)
	{
		relatedElements.add(relatedElement);
	}
	
	protected abstract FormElementViewController createViewController();
	
	public FormElementViewController viewController()
	{
		if (viewController == null)
		{
			viewController = createViewController();
		}
		
		return viewController;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof FormElement))
		 {
			 return false;
		 }
		 
		 FormElement value = (FormElement) object;
		 
		 if (this.identifier == null && value.identifier == null)
		 {
			 return true;
		 }
		 
		 if (this.identifier == null && value.identifier == null)
		 {
			 return false;
		 }
		 
		 if (!(this.identifier.equals(value.identifier)))
		 {
			 return false;
		 }

		 return true;
	 }
}
