package org.uva.sea.ql.AST;


<<<<<<< HEAD
public abstract class Node {
	public abstract void accept(Visitor visitor);
=======
public interface Node {
	public <T> T accept(Visitor<T> visitor);
>>>>>>> 2ff1850cf0b0505b45f85d628e7f2ebddba5d66e
}
