package org.nlamah.QLS.Model;

public abstract class StyleDeclaration extends QLSNode 
{
	private DeclarationValue value;
	
	public StyleDeclaration(DeclarationValue value)
	{
		super();
		
		this.value = value;
	}
}
