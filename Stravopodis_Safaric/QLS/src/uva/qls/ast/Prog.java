package uva.qls.ast;

import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.*;

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
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitProg(this);
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
		return "Prog("+ this.styleSheet.toString() + ")";
	}

}
