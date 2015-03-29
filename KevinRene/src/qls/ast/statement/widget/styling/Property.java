package qls.ast.statement.widget.styling;

import java.util.List;

import ql.Value;
import ql.ast.QLType;
import qls.ast.Statement;
import qls.ast.expression.Literal;

public abstract class Property extends Statement {
	private final List<QLType> compatibleTypes;
	private final Literal<?> literal;
	
	public Property(List<QLType> compatibleTypes, Literal<?> literal) {
		this.compatibleTypes = compatibleTypes;
		this.literal = literal;
	}
	
	protected final Value value() {
		return literal.getValue();
	}
	
	public Literal<?> getLiteral() {
		return literal;
	}
	
	public boolean isCompatibleWith(QLType type) {
		return compatibleTypes.contains(type);
	}
	
	@Override
	public final int hashCode() {
		return this.getClass().getSimpleName().hashCode();
	}
	
	@Override
	public final boolean equals(Object comparisonObject) {
		return hashCode() == comparisonObject.hashCode();
	};

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + literal.toString() + ")";
	}
}
