package uva.qls.ast.statements;

import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;

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
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
	}
	
	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
	
	@Override
	public String toString(){
		return "Subsection(" + this.getName() + "," + question.toString() + ")";
	}
}
