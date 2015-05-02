package org.nlamah.QLS.Model.Abstract;

public abstract class StyleDeclaration extends QLSNode 
{
	private DeclarationValue value;
	
	public StyleDeclaration(DeclarationValue value)
	{
		super();
		
		this.value = value;
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
		 
		 StyleDeclaration styleDeclaration = (StyleDeclaration) object;
		 
		 if (!(value.equals(styleDeclaration.value)))
		 {
			 return false;
		 }

		 return true;
	 }
}