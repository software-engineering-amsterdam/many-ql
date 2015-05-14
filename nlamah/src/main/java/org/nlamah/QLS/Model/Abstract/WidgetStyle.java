package org.nlamah.QLS.Model.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class WidgetStyle extends DeclarationValue 
{
	QBaseQuestionType type;
	
	public WidgetStyle(QBaseQuestionType type)
	{
		super();
		
		this.type = type;
	}
	
	public QBaseQuestionType type()
	{
		return type;
	}
}
