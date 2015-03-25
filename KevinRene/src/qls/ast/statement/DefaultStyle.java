package qls.ast.statement;

import ql.ast.QLType;
import qls.ast.Statement;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.visitor.StatementVisitor;

public class DefaultStyle extends Statement {	
	private final QLType type;
	private final StyleProperties ruleSet;
	
	public DefaultStyle (QLType type, StyleProperties ruleSet) {
		this.type = type;
		this.ruleSet = ruleSet;
	}
	
	public QLType getType() {
		return type;
	}
	
	public StyleProperties getStyleProperties() {
		return ruleSet;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Default";
	}

}
