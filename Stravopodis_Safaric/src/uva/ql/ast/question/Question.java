package uva.ql.ast.question;

import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.Literal;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.statements.StatementVisitor;

public class Question extends Statement {
	
	private Identifier identifier;
	private Literal type;
	private List<Statement> statement;
	
	public Question(Identifier _identifier, Literal _type, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.statement = _statement;
	}
	
	public List<Statement> getStatement(){
		return this.statement;
	}
	public Literal getType(){
		return this.type;
	}
	public Identifier getIdentifier(){
		return this.identifier;
	}
	@Override
	public String toString(){
		return "Question(" + this.identifier.evaluate().getValue().toString() + ","  + this.type.toString() + ", Statement(" + this.statement.toString() + "))";
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitQuestion(this);
	}
}



