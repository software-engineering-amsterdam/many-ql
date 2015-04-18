package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public interface TypeAware 
{
	public boolean isSafeForType(QuestionReturnType type);
}
