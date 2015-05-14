package org.nlamah.QLS.Error;

import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QBase.Error.QBaseError;

public class WidgetTypeMismatchError extends QBaseError 
{
	private WidgetDeclaration widgetDeclaration;
	private QBaseQuestionType neededType;

	public WidgetTypeMismatchError(WidgetDeclaration widgetDeclaration, QBaseQuestionType neededType)
	{
		super();

		assert(widgetDeclaration != null);
		assert(neededType != null);
		
		this.widgetDeclaration = widgetDeclaration;
		this.neededType = neededType;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + widgetDeclaration.startsOnLine + ":"  + widgetDeclaration.startsAtCharacterPosition;

		errorString += " The type of the widget declaration on this line isn't of the right type: ";
		errorString +=  widgetDeclaration.returnType().toString();
		errorString += " vs " + neededType.toString();

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof WidgetTypeMismatchError))
		{
			return false;
		}

		WidgetTypeMismatchError value = (WidgetTypeMismatchError)object;

		if (!this.widgetDeclaration.equals(value.widgetDeclaration))
		{
			return false;
		}

		return true;
	}
}
