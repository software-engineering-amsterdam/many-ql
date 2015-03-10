package qls.ast.visitor;

import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import qls.ast.QLSStatement;
import qls.ast.statement.Default;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.stylerule.StyleRule;
import qls.ast.stylerule.StyleRuleSet;
import qls.ast.widget.Checkbox;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinner;
import qls.ast.widget.TextField;
import qls.ast.widget.ValueSet;

/**
 * Refused bequest. Who cares?
 * 
 * @author Rene
 */
public abstract class QLSStatementVisitor<T> extends StatementVisitor<T> implements ExpressionVisitor<T> {
	public QLSStatementVisitor() {
		super.setExpressionVisitor(this);
	}
	
	public abstract T visit(Default defaultNode);
	
	public T visit(Page pageNode) {
		pageNode.accept(this);
		return null;
	}
	
	public T visit(QLSBlock blockNode) {
		for(QLSStatement statement : blockNode.statements()) {
			statement.accept(this);
		}
		return null;
	}
	
	public abstract T visit(Question questionNode);
	public abstract T visit(Section sectionNode);
	
	public T visit(Stylesheet stylesheetNode) {
		stylesheetNode.getIdentifier().accept(this);	
		stylesheetNode.getBlock().accept(this);
		return null;
	}
	
	public abstract T visit(Checkbox checkboxNode);
	public abstract T visit(Dropdown dropdownNode);
	public abstract T visit(RadioButton radioButtonNode);
	public abstract T visit(TextField textFieldNode);
	public abstract T visit(Spinner spinnerNode);
	public abstract T visit(Slider sliderNode);

	public abstract T visit(StyleRule styleRuleNode);
	public T visit(StyleRuleSet styleRuleSetNode) {
		for(StyleRule rule : styleRuleSetNode.rules()) {
			rule.accept(this);
		}
		return null;
	}
	public T visit(ValueSet valueSetNode) {
		for(Literal value : valueSetNode.values()) {
			value.accept(this);
		}
		return null;
	}
}