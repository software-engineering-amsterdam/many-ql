package uva.qls.ast;

public class Page extends ASTNode {
	
	private Identifier identifier;
	private List<Statement> statement;
	
	public Page (Identifier _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
	}
	
	public Page (Identifier _identifier, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
	}

	public Identifier getIdentifier(){
		return this.identifier;
	}
	public List<Statement> getStatement(){
		return this.statement;
	}
	public CodeLines getCodeLines(){
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




