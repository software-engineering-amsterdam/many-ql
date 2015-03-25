package uva.qls.ast.literal;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.StringValue;

public class Identifier extends Literal {
	
	private String identifier;
	
	public Identifier (String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
	}
	
	public String evaluatedValue(){
		return this.evaluate().getValue();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitIdentifier(this);
	}
	
	public CodeLines getLOC() {
		return this.codeLines;
	}

	@Override
	public StringValue evaluate(){
		return new StringValue(this.identifier);
	}
	
	@Override
	public String toString() {
		
		return "Identifier(" + this.identifier + ")";
	}
}
