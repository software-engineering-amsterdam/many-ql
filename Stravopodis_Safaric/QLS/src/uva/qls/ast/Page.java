package uva.qls.ast;

import java.util.*;

import uva.qls.ast.literal.Identifier;
import uva.qls.ast.statements.*;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;
public class Page extends ASTNode {
	
	private Identifier identifier;
	private List<Statement> statement;
	
	public Page (Identifier _identifier, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
		this.statement = _statement;
	}

	public Identifier getIdentifier(){
		return this.identifier;
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
		return "Page(" + this.identifier.toString() + "," + statement.toString() + ")";
	}
}




