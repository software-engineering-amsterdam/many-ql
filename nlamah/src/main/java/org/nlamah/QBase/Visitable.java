package org.nlamah.QBase;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public interface Visitable
{
	public QLNode accept(QLNodeVisitor visitor);
}
