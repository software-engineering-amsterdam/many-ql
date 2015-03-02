package uva.qls.ast;

import uva.qls.ast.value.GenericValue;

public class Prog extends ASTNode {
	
	private StyleSheet styleSheet;
	
	public Prog (StyleSheet _styleSheet, CodeLines _codeLines){
		super(_codeLines);
		this.styleSheet= _styleSheet;
	}
	
	public StyleSheet getStyleSheet(){
		return this.styleSheet;
	}

	@Override
	public GenericValue<?> evaluate() {
		
		return null;
	}
	
	@Override
	public String toString(){
		return "Prog("+ this.styleSheet.toString() + ")";
	}

}
