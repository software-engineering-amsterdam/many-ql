package uva.ql.ast.question;

import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.visitor.StatementVisitorInterface;

public class Question extends Statement {
	
	private Identifier identifier;
	private Type type;
	private List<Statement> statement;
	
	public Question(Identifier _identifier, Type _type, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.statement = _statement;
	}
	
	public List<Statement> getStatement(){
		return this.statement;
	}
	
	public Type getType(){
		return this.type;
	}
	
	public Identifier getIdentifier(){
		return this.identifier;
	}
	
	public CodeLines getCodeLines(){
		return this.codeLines;
	}
	public String getQuestionText(){
		String questionText = "";
		
		for (Statement s : this.statement){
			if (s.getClass().equals(Assign.class)){
				Assign assign = (Assign)s;
				if (assign.getExpression().getClass().equals(StringLiteral.class))
					questionText = String.valueOf(assign.getExpression().evaluate().getValue());
			}
		}
		
		return questionText.replaceAll("[\"]", "");	// Remove quotes
	}
	
	@Override
	public <T> T accept(StatementVisitorInterface<T> visitor) {
		return visitor.visitQuestion(this);
	}
	
	@Override
	public String toString(){
		return "Question(" + this.identifier.evaluate().getValue().toString() + ","  + this.type.toString() + ", Statement(" + this.statement.toString() + "))";
	}
}



