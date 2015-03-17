package qls.ast.statement.styling;

import java.util.ArrayList;
import java.util.List;

import qls.ast.QLSStatement;
import qls.ast.visitor.StatementVisitor;

public class StyleProperties extends QLSStatement {
	private List<Property> properties = new ArrayList<Property>();
	
	public StyleProperties() {}
	
	public StyleProperties(Property rule) {
		properties.add(rule);
	}
	
	public StyleProperties(Property rule, StyleProperties set) {
		properties.add(rule);
		properties.addAll(set.getProperties());
	}
	
	public List<Property> getProperties() {
		return properties;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("StyleProperties(");
		
		for(Property rule : properties) {
			sb.append(rule.toString() + ", ");
		}
		
		if (properties.size() > 0) {
			sb.setLength(sb.length() - 2);
		}
		sb.append(")");
		
		return sb.toString();
	}

}
