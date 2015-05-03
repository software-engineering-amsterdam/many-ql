package org.nlamah.QLS.Model.Abstract;

import org.nlamah.QBase.QBaseQuestionType;

public abstract class WidgetType extends DeclarationValue 
{
	QBaseQuestionType type;
	
	public WidgetType(QBaseQuestionType type)
	{
		super();
		
		this.type = type;
	}
	
	public QBaseQuestionType type()
	{
		return type;
	}
}
