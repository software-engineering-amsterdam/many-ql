package uva.sc.types;

import uva.sc.ast.INode;
import uva.sc.logic.Expression;

public interface Type extends INode{
	
	boolean equals(Type type);

	Expression defaultValue();

}