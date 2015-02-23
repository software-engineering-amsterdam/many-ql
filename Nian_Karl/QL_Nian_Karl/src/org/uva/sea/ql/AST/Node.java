package org.uva.sea.ql.AST;

import java.util.List;

public abstract class Node {
	public abstract void accept(Visitor visitor);
}
