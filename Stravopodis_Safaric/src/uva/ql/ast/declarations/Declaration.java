package uva.ql.ast.declarations;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.Literal;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.statements.StatementVisitor;

public class Declaration extends Statement{

	private Identifier identifier;
	private Literal type;
	private Expression expressions;
	
	public Declaration(Identifier _identifier, Literal _type, Expression _expressions, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.expressions = _expressions;
	}
	public Declaration(Identifier _identifier, Literal _type, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
	}
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public Literal getType(){
		return this.type;
	}
	public Expression getExpression(){
		return this.expressions;
	}
	@Override
	public String toString(){
		if (this.expressions == null) return "Declaration(" + this.identifier.evaluate().getValue() + "," + this.type.toString() + ")";
		else return "Declaration(" + this.identifier.evaluate().getValue() + "," + this.type.toString() +"," + this.expressions.toString() + ")";
	}
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitDeclaration(this);
	}
}
