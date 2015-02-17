package uva.ql.ast.question;

import uva.ql.ast.ASTNode;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;

public abstract class QuestionDeclaration extends Statement implements ASTNode{
	protected Identifier identifier;
	protected String questionString;
	
	public QuestionDeclaration(Identifier _identifier, String _questionString){
		this.identifier = _identifier;
		this.questionString = _questionString;
	}
	
}
