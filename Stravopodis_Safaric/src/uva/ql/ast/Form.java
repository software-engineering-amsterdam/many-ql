package uva.ql.ast;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;

public class Form extends ASTNode{
	
	private Identifier identifier;
	private Statement statement;
	
	public Form (Identifier _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
	}
	public Form(Identifier _identifier, Statement _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.statement = _statement;
	}
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public Statement getStatement(){
		return this.statement;
	}
	@Override
	public String toString(){
		return "Form(" + this.identifier.toString() + "," + statement.toString() + ")";
	}
}
