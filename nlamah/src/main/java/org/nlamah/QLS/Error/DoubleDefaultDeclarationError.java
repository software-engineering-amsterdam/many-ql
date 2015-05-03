package org.nlamah.QLS.Error;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;

public class DoubleDefaultDeclarationError extends QBaseError 
{
	private List<DefaultDeclaration> defaultDeclarations;
	
	public DoubleDefaultDeclarationError(List<DefaultDeclaration>defaultDeclarations) 
	{
		super();
		
		this.defaultDeclarations = defaultDeclarations;
	}

	@Override
	public String description() 
	{			
		String errorString = "ERROR: Line " + defaultDeclarations.get(0).startsOnLine + ":"  + defaultDeclarations.get(0).startsAtCharacterPosition;

		errorString += ", The question with Identifier \"" + defaultDeclarations.get(0).toString() + "\" is placed more than once in the stylesheet.<br/>";

		for (DefaultDeclaration defaultDeclaration : defaultDeclarations)
		{
			errorString += "<div style='margin-left:45px'>See line: " + defaultDeclaration.startsOnLine + "<br/></div>";
		}

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof DoubleDefaultDeclarationError))
		{
			return false;
		}

		DoubleDefaultDeclarationError value = (DoubleDefaultDeclarationError) object;

		if (!this.defaultDeclarations.equals(value.defaultDeclarations))
		{
			return false;
		}

		return true;
	}
}
