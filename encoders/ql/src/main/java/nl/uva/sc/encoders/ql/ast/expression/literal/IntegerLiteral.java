package nl.uva.sc.encoders.ql.ast.expression.literal;

import java.util.Set;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.TypeMap;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class IntegerLiteral extends Expression {

	private final int value;

	public IntegerLiteral(TextLocation textLocation, int value) {
		super(textLocation);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void collectQuestionNames(Set<String> relatedQuestionNames) {
		// Do nothing, because there are no related questions to literals.
	}

	@Override
	public DataType getType(TypeMap typeMap) {
		return new IntegerType();
	}
}
