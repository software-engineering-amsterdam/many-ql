package org.nlamah.QLS.Model;

import java.util.ArrayList;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public class DefaultDeclaration extends SectionElement 
{
	private String type;
	private ArrayList<StyleDeclaration> styleDeclarations;
	
	public DefaultDeclaration(String type, ArrayList<StyleDeclaration> styleDeclarations)
	{
		super();
		
		this.type = type;
		this.styleDeclarations = styleDeclarations;
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
