package org.nlamah.QLS.Model.Abstract;

public abstract class StyleDeclaration extends QLSNode 
{	
	public StyleDeclaration()
	{
		super();
	}

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
