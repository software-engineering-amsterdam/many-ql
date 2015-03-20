package uva.qls.ast.statements;

import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.statements.visitor.StatementVisitor;

public class Subsection extends Statement {
	
	private StringLiteral name;
	private Question question;
	
	public Subsection (StringLiteral _name, Question _question, CodeLines _codeLines){
		super(_codeLines);
		this.name=_name;
		this.question=_question;
	}
	
	public Question getQuestion(){
		return this.question;
	}
	public StringLiteral getName(){
		return this.name;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitSubsection(this);
	}

	@Override
	public String toString(){
		return "Subsection(" + this.getName() + "," + question.toString() + ")";
	}
}
