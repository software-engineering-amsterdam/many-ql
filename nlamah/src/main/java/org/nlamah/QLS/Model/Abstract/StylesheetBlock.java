package org.nlamah.QLS.Model.Abstract;

import java.util.List;

import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;

public abstract class StylesheetBlock extends QLSNode 
{
	protected DeclarationValue title;
	protected List<DefaultDeclaration> defaultDeclarations;
	
	public StylesheetBlock(DeclarationValue title, List<DefaultDeclaration> defaultDeclarations)
	{
		super();
		
		this.title = title;
		this.defaultDeclarations = defaultDeclarations;
		
		title.setParentNode(this);

		for (DefaultDeclaration defaultDeclaration : defaultDeclarations)
		{
			defaultDeclaration.setParentNode(this);
		}
	}
	
	public List<DefaultDeclaration> defaultDeclarations()
	{
		return defaultDeclarations;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof StylesheetBlock))
		 {
			 return false;
		 }
		 
		 StylesheetBlock value = (StylesheetBlock) object;
		 
		 if (this.title == null && value.title == null)
		 {
			 return true;
		 }
		 
		 if (!(this.title.equals(value.title)))
		 {
			 return false;
		 }
		 
		 if (!(this.defaultDeclarations.equals(value.defaultDeclarations)))
		 {
			 return false;
		 }

		 return true;
	 }
}
