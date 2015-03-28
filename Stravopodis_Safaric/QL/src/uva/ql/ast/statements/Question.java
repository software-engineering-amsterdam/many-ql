package uva.ql.ast.statements;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.type.Type;
import uva.ql.ast.visitor.StatementVisitor;

public class Question extends Statement {
	
	private StringLiteral questionLabel;
	private Identifier identifier;
	private Expression expression;
	private Type type;
	
	public Question(Type _type, Identifier _identifier, StringLiteral _questionLabel, CodeLines _codeLines){
		super(_codeLines);
		
		this.type = _type;
		this.identifier = _identifier;
		this.questionLabel = _questionLabel;
	}
	
	public Question(Type _type, Identifier _identifier, StringLiteral _questionLabel, Expression _expression, CodeLines _codeLines){
		super(_codeLines);
		
		this.type = _type;
		this.identifier = _identifier;
		this.questionLabel = _questionLabel;
		this.expression = _expression;
	}
	
	public Expression getQuestionExpression(){
		return this.expression;
	}
	
	public Type getQuestionType(){
		return this.type;
	}
	
	public boolean questionTypeEquals(Type type){
		return this.type.equals(type);
	}
	
	public Identifier getQuestionIdentifier(){
		return this.identifier;
	}
	
	public String getQuestionIdentifierValue(){
		return this.identifier.getValue();
	}
	
	public StringLiteral getQuestionLabel(){
		return this.questionLabel;
	}
	
	public String getQuestionLabelText(){
		String labelTextValue = this.getQuestionLabel().getValue();
		return labelTextValue.replaceAll("\"", "");
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		if (this.expression == null){
			return visitor.visitSimpleQuestion(this);
		}
		
		return visitor.visitComputedQuestion(this);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public String toString(){
		return "Question(" + this.identifier + ","  + this.type + "," + this.questionLabel + "," + this.expression + "))";
	}
}