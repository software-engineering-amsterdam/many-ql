package org.nlamah.QLS.Model.Abstract;

public abstract class StyleDeclaration extends QLSNode 
{
	protected DeclarationValue value;
	
	public StyleDeclaration(DeclarationValue value)
	{
		super();
	
		this.value = value;
		
		if (value != null)
		{
			value.setParentNode(this);
		}
	}
	
	public DeclarationValue value()
	{
		return value;
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
		 
		 if (value == null && styleDeclaration.value == null)
		 {
			 return true;
		 }
		 
		 if (!(value.equals(styleDeclaration.value)))
		 {
			 return false;
		 }

		 return true;
	 }
}
