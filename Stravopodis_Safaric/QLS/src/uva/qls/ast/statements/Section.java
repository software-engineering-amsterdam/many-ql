package uva.qls.ast.statements;

import java.util.List;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

public class Section extends Statement {
	
	private String name;
	private List<Statement> statement;
	
	
	public Section (String _name,List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.name=_name;
		this.statement=_statement;
		
	}
	
	public String getName(){
		return this.name;
	}
	public List<Statement> getStatement(){
		return this.statement;
	}
	
	public boolean hasStatements(){
		return this.statement == null ? false : !this.statement.isEmpty();
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
		return "Section(" + this.getName() + "," + this.statement.toString() + ")";
	}
	
}
