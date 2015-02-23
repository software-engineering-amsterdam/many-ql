package org.uva.sea.ql.AST;

import java.util.List;

public interface Node {
	public void accept(Visitor visitor);
}
