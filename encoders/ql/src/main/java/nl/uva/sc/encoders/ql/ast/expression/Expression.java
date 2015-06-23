package nl.uva.sc.encoders.ql.ast.expression;

import java.util.Set;

import nl.uva.sc.encoders.ql.ast.AstNode;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.TypeMap;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public abstract class Expression extends AstNode {

	public Expression(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract <T> T accept(ExpressionVisitor<T> visitor);

	public abstract void collectQuestionNames(Set<String> relatedQuestionNames);

	public abstract DataType getType(TypeMap typeMap);
}
