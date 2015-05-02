package org.nlamah.QL.Interfaces;

import org.nlamah.QBase.QBaseQuestionType;

public interface TypeAware 
{
	public boolean isSafeForType(QBaseQuestionType type);
}
