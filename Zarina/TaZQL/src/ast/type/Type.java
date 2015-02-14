package ast.type;

import ast.AST;


public abstract class Type extends AST {

	public abstract <T> T accept(ITypeVisitor<T> visitor);

}
