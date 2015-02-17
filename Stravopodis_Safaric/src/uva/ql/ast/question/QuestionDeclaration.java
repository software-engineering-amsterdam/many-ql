package uva.ql.ast.question;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public abstract class QuestionDeclaration extends Statement {
	protected Identifier identifier;
	protected String questionString;
	
	public QuestionDeclaration(Identifier _identifier, String _questionString, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.questionString = _questionString;
	}
	
}
