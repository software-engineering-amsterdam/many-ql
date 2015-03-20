package uva.qls.ast.statements;

import java.util.List;

import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.statements.visitor.StatementVisitor;

public class Section extends Statement {
	
	private StringLiteral name;
	private List<Statement> statement;
	
	public Section (StringLiteral _name,List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.name=_name;
		this.statement=_statement;
		
	}
	
	public StringLiteral getName(){
		return this.name;
	}
	public List<Statement> getStatement(){
		return this.statement;
	}
	
	public boolean hasStatements(){
		return this.statement == null ? false : !this.statement.isEmpty();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitSection(this);
	}
	
	@Override
	public String toString(){
		return "Section(" + this.getName() + "," + this.statement.toString() + ")";
	}
	
}
