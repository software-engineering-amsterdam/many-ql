package nl.uva.sc.encoders.qls.ast.property;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.ast.AstNode;
import nl.uva.sc.encoders.qls.visitor.DefaultPropertyVisitor;

public abstract class DefaultStyleProperty extends AstNode {

	public DefaultStyleProperty(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract <T> T accept(DefaultPropertyVisitor<T> visitor);

}
