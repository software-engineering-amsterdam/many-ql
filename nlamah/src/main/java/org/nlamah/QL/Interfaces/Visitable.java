package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.Abstract.QLNode;

public interface Visitable
{
	public QLNode accept(QLNodeVisitor visitor);
}
