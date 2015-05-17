package org.nlamah.QLS.Error;

import java.util.List;

import org.nlamah.QBase.Error.QBaseParsingError;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class DoublePropertyDeclarationError extends QBaseParsingError 
{
	private List<StyleDeclaration> styleDeclarations;

	public DoublePropertyDeclarationError(List<StyleDeclaration> styleDeclarations)
	{
		super(0,0);

		this.styleDeclarations = styleDeclarations;
	}

	@Override
	public String description() 
	{
		String errorString = "ERROR: Line " + styleDeclarations.get(0).startsOnLine + ":"  + styleDeclarations.get(0).startsAtCharacterPosition;

		errorString += ", The style property: \"" + styleDeclarations.get(0).toString() + "\" is placed more than once in the same block.<br/>";

		for (StyleDeclaration styleDeclaration : styleDeclarations)
		{
			errorString += "<div style='margin-left:45px'>See line: " + styleDeclaration.startsOnLine + "<br/></div>";
		}

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof DoublePropertyDeclarationError))
		{
			return false;
		}

		DoublePropertyDeclarationError value = (DoublePropertyDeclarationError)object;


		if (!this.styleDeclarations.equals(value.styleDeclarations))
		{
			return false;
		}

		return true;
	}
}
