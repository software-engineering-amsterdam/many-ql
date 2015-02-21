package uva.ql.ast.declarations;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;

public class Declaration extends Statement{

	private Identifier identifier;
	private ASTNode type;
	private Expression expressions;
	
	public Declaration(Identifier _identifier, ASTNode _type, Expression _expressions, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.expressions = _expressions;
	}
	public Declaration(Identifier _identifier, ASTNode _type, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
	}
	public ASTNode getType(){
		return this.type;
	}
	@Override
	public String toString(){
		if (this.expressions == null) return "Declaration(" + this.identifier.getValue().toString() + "," + this.type.toString() + ")";
		else return "Declaration(" + this.identifier.getValue().toString() + "," + this.type.toString() +"," + this.expressions.toString() + ")";
	}
}
