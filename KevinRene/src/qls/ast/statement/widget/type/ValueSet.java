package qls.ast.statement.widget.type;

import java.util.ArrayList;
import java.util.List;

import qls.ast.expression.Literal;
import qls.ast.QLSStatement;
import qls.ast.visitor.StatementVisitor;

public class ValueSet extends QLSStatement {	
	private List<Literal<?>> values = new ArrayList<Literal<?>>();
	
	public ValueSet(Literal<?> value) {
		values.add(value);
	}
	
	public ValueSet(Literal<?> value, ValueSet set) {
		values.add(value);
		values.addAll(set.values());
	}
	
	public List<Literal<?>> values() {
		return values;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("StyleRuleSet(");
		
		for(Literal<?> rule : values) {
			sb.append(rule.toString() + ", ");
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(")");
		
		return sb.toString();
	}

}
