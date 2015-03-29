package uva.qls.ast;

import uva.qls.ast.statements.visitor.StatementVisitor;


public class Prog extends ASTNode {
	
	private StyleSheet styleSheet;
	
	public Prog (StyleSheet _styleSheet, CodeLines _codeLines){
		super(_codeLines);
		this.styleSheet= _styleSheet;
	}
	
	public StyleSheet getStyleSheet(){
		return this.styleSheet;
	}
	
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitProg(this);
	}
		
	@Override
	public String toString(){
		return "Prog("+ this.styleSheet.toString() + ")";
	}

}
