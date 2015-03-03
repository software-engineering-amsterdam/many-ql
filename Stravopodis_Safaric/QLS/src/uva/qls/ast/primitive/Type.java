package uva.qls.ast.primitive;

import uva.qls.ast.primitive.PrimitiveType;
import uva.qls.ast.ASTNode;
import uva.qls.ast.CodeLines;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public class Type extends ASTNode{

	private PrimitiveType primitiveType;
	private String name;
	
	public Type(String _type, CodeLines _codeLines) {
		super(_codeLines);
		this.primitiveType = this.findPrimitiveType(_type);
		this.name = this.primitiveType.getName();
	}

	private PrimitiveType findPrimitiveType(String _type){
		return PrimitiveType.findOperator(_type);
	}
	public String getTypeName(){
		return this.name;
	}
	public PrimitiveType getPrimitiveType(){
		return this.primitiveType;
	}
	
	@Override
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
	}

	@Override
	public GenericValue<?> evaluate() {
	return null;
	}

	@Override
	public String toString(){
		return "PrimitiveType(" + this.name + ")";
	}
	
	
}
