package nl.uva.sc.encoders.ql.ast.expression;

import java.util.Set;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.TypeMap;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class NameExpression extends Expression {

	private String name;

	public NameExpression(TextLocation textLocation, String name) {
		super(textLocation);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void collectQuestionNames(Set<String> relatedQuestionNames) {
		relatedQuestionNames.add(name);
	}

	@Override
	public DataType getType(TypeMap typeMap) {
		return typeMap.get(name);
	}
}
