package qls.ast.stylerule;

import java.util.ArrayList;
import java.util.List;

import qls.ast.QLSStatement;
import qls.ast.visitor.QLSStatementVisitor;

public class StyleRuleSet extends QLSStatement {
	private List<StyleRule> rules = new ArrayList<StyleRule>();
	
	public StyleRuleSet(StyleRule rule) {
		rules.add(rule);
	}
	
	public StyleRuleSet(StyleRule rule, StyleRuleSet set) {
		rules.add(rule);
		rules.addAll(set.rules());
	}
	
	public List<StyleRule> rules() {
		return rules;
	}

	@Override
	public <T> T accept(QLSStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("StyleRuleSet(");
		
		for(StyleRule rule : rules) {
			sb.append(rule.toString() + ", ");
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(")");
		
		return sb.toString();
	}

}
