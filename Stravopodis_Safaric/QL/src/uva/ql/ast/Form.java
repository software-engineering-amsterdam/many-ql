package uva.ql.ast;

import java.util.List;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.visitor.*;

public class Form extends ASTNode{
	
	private Identifier identifier;
	private List<Statement> statement;
	
	public Form (Identifier _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
	}
	
	public Form(Identifier _identifier, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.statement = _statement;
	}
	
	public Identifier getIdentifier(){
		return this.identifier;
	}
	
	public List<Statement> getStatement(){
		return this.statement;
	}
	
	public <T> T accept(StatementVisitor<T> visitor){
		return visitor.visitForm(this);
	}
	
	@Override
	public String toString(){
		return "Form(" + this.identifier.toString() + "," + statement.toString() + ")";
	}
}
