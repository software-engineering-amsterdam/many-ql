package uva.ql.ast.type;

import java.util.List;

import uva.ql.ast.Node;
import uva.ql.ast.CodeLines;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.TypeVisitor;

public abstract class Type extends Node{
	
	public abstract <T> T accept(TypeVisitor<T> visitor); 
	public abstract GenericValue<?> typeInitialValue();
	
	public Type(){
		super();
	}
	
	public Type(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public boolean typeDoesConfirm(List<Type> supportedTypes) {
		
		for (Type type : supportedTypes){
			if (this.equals(type)){
				return true;
			}
		}	
		
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		return this.getClass() == obj.getClass();
	}
}
