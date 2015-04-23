package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public interface TypeAware 
{
	public boolean isSafeForType(LiteralType type);
}
