package org.nlamah.QL.Model.Form;

import java.util.List;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;

public class ElseThenBlock extends DeclaringFormElement 
{		
	public ElseThenBlock(List<FormElement> childElements) 
	{
		super(childElements);	
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

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);
	}
}