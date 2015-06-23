package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.Abstract.QLNode;

public interface QLVisitable
{
	public QLNode accept(QLNodeVisitor visitor);
}