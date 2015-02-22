package uva.ql.ast.question;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;

public class Question extends Statement {
	
	private Identifier identifier;
	private ASTNode type;
	private Statement statement;
	
	public Question(Identifier _identifier, ASTNode _type, Statement _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.statement = _statement;
	}
	
	public Statement getStatement(){
		return this.statement;
	}
	public ASTNode getType(){
		return this.type;
	}
	
	@Override
	public String toString(){
		return "Question(" + this.identifier.getValue().toString() + ","  + this.type.toString() + ", Statement(" + this.statement.toString() + "))";
	}
}



