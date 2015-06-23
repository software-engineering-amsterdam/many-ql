package org.nlamah.QL.Interfaces;

import org.nlamah.QBase.Constants.QBaseQuestionType;

public interface TypeAware 
{
	public boolean isSafeForType(QBaseQuestionType type);
}