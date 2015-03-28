package uva.ql.ast.expression.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import uva.ql.ast.Form;
import uva.ql.ast.Node;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.Literal;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Question;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.StatementVisitor;

public class ValueTable implements StatementVisitor<Void>{

	private final Map<String, GenericValue<?>> valueTable = new HashMap<String, GenericValue<?>>();
	private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	private final Prog prog;
	
	public ValueTable(Prog _prog) {
		this.prog = _prog;
		this.visitProg(this.prog);
		
	}
	
	public void refreshValueTable(){
		this.visitProg(this.prog);
	}
	
	public Map<String, GenericValue<?>> getValueTable(){
		return this.valueTable;
	}
	
	public Set<String> getKeySet(){
		return this.valueTable.keySet();
	}
	
	public GenericValue<?> getValue(String identifier){
		return this.valueTable.get(identifier);
	}
	
	public void updateValueTable(Identifier identifier, GenericValue<?> value){
		this.valueTable.put(identifier.getValue(), value);
	}
	
	public boolean conditionalExpression(Expression expression){
		GenericValue<?> value = this.expressionEvaluator.visitExpressionWithValueTable(expression, this);
		return (boolean)value.getValue();
	}
	
	@Override
	public Void visitProg(Prog prog) {
		prog.getForm().accept(this);
		return null;
	}

	@Override
	public Void visitForm(Form form) {
		
		for(Statement statement : form.getFormStatements()){
			statement.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visitASTNode(Node node) {
		return null;
	}

	@Override
	public Void visitStatement(Statement statement) {
		statement.accept(this);
		return null;
	}

	@Override
	public Void visitSimpleQuestion(Question question) {
		GenericValue<?> questionInitialValue = question.getQuestionType().typeInitialValue();
		String questionIdentifier = question.getQuestionIdentifier().evaluate().getValue();
		
		if (!this.valueTable.containsKey(questionIdentifier)){
			this.valueTable.put(questionIdentifier, questionInitialValue);
		}
		
		return null;
	}

	@Override
	public Void visitComputedQuestion(Question question) {
		
		GenericValue<?> expression = this.expressionEvaluator.visitExpressionWithValueTable(question.getQuestionExpression(), this);
		String questionIdentifier = question.getQuestionIdentifierValue();
	
		// Aware of the Code Smell instanceof and its binding to am implementation
		if (this.valueTable.containsKey(questionIdentifier) && question.getQuestionExpression() instanceof Literal){
			return null;
		}
		
		this.valueTable.put(questionIdentifier, expression);
		
		return null;
	}

	@Override
	public Void visitIfStatement(IfStatement ifStatement) {
		
		for (Statement statement : ifStatement.getStatements()){
			statement.accept(this);
		}
		
		this.expressionEvaluator.visitExpressionWithValueTable(ifStatement.getIfStatementExpression(), this);
		
		return null;
	}

	@Override
	public Void visitAssign(Assign assign) {
		this.expressionEvaluator.visitExpressionWithValueTable(assign.getAssignExpression(), this);
		
		return null;
	}
}
