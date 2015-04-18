package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.ViewControllers.Form.ElseThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class ElseThenBlock extends DeclaringFormElement 
{		
	public ElseThenBlock(ArrayList<FormElement> childElements) 
	{
		super(childElements);	
	}

	@Override
	protected FormElementViewController createViewController() 
	{
		return new ElseThenBlockViewController(this);
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
		 
		 if (!(object instanceof ElseThenBlock))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
