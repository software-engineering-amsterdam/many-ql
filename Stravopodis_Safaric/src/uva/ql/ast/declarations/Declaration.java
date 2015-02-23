package uva.ql.ast.declarations;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.visitor.VisitorInterface;

public class Declaration extends Statement{

	private Identifier identifier;
	private Type type;
	private Expression expressions;
	
	public Declaration(Identifier _identifier, Type _type, Expression _expressions, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.expressions = _expressions;
	}
	public Declaration(Identifier _identifier, Type _type, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
	}
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public Type getType(){
		return this.type;
	}
	public Expression getExpression(){
		return this.expressions;
	}
	public CodeLines getCodeLines(){
		return this.codeLines;
	}
	@Override
	public String toString(){
		if (this.expressions == null) return "Declaration(" + this.identifier.evaluate().getValue() + "," + this.type.toString() + ")";
		else return "Declaration(" + this.identifier.evaluate().getValue() + "," + this.type.toString() +"," + this.expressions.toString() + ")";
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitDeclaration(this);
	}
}
