package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public interface Visitable
{
	public QLNode accept(QLNodeVisitor visitor);
}
