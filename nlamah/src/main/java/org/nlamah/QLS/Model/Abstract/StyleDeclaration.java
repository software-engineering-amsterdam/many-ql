package org.nlamah.QLS.Model.Abstract;

public abstract class StyleDeclaration extends QLSNode 
{	
	@Override 
	public boolean equals(Object object) 
	{
		if (this == object)
		{
			return true;
		}

		if (!(object instanceof StyleDeclaration))
		{
			return false;
		}

		return true;
	}
}