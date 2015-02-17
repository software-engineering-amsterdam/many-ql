package uva.ql.ast.question;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public class QuestionDeclaration extends Statement {
	
	private Identifier identifier;
	private String questionString;
	
	public QuestionDeclaration(Identifier _identifier, String _questionString, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.questionString = _questionString;
	}
	
	@Override
	public String toString(){
		return this.getClass().getName() + "(" + this.identifier.getValue() + "," + this.questionString + ")";
	}
}
