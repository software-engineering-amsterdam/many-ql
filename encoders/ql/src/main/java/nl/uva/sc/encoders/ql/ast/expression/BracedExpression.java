package nl.uva.sc.encoders.ql.ast.expression;

import java.util.Set;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.TypeMap;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class BracedExpression extends Expression {

	private Expression expression;

	public BracedExpression(TextLocation textLocation, Expression expression) {
		super(textLocation);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(expression);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void collectQuestionNames(Set<String> relatedQuestionNames) {
		expression.collectQuestionNames(relatedQuestionNames);
	}

	@Override
	public DataType getType(TypeMap typeMap) {
		return expression.getType(typeMap);
	}
}
