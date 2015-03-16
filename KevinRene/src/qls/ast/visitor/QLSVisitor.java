package qls.ast.visitor;

import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;
import qls.ast.QLSStatement;
import qls.ast.statement.Default;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.stylerule.StyleRule;
import qls.ast.stylerule.StyleRuleSet;
import qls.ast.stylerule.property.Color;
import qls.ast.stylerule.property.Font;
import qls.ast.stylerule.property.FontSize;
import qls.ast.stylerule.property.Height;
import qls.ast.stylerule.property.Width;
import qls.ast.widget.Checkbox;
import qls.ast.widget.DefaultWidget;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinbox;
import qls.ast.widget.TextField;
import qls.ast.widget.ValueSet;

/**
 * Refused bequest. Who cares?
 * 
 * @author Rene
 */
public abstract class QLSVisitor<T> extends StatementVisitor<T> implements ExpressionVisitor<T>, TypeVisitor<T> {
	public QLSVisitor() {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
	}
	
	
	public T visit(Page pageNode) {
		pageNode.getIdentifier().accept(this);
		pageNode.getStatements().accept(this);
		return null;
	}
	
	public T visit(QLSBlock blockNode) {
		for(QLSStatement statement : blockNode.statements()) {
			statement.accept(this);
		}
		return null;
	}
	
	public T visit(Question questionNode) {
		questionNode.getIdentifier().accept(this);
		questionNode.getWidget().accept(this);
		return null;
	}
	
	public T visit(Section sectionNode) {
		sectionNode.getHeader().accept(this);
		sectionNode.getStatements().accept(this);
		return null;
	}
	
	public T visit(Stylesheet stylesheetNode) {
		stylesheetNode.getIdentifier().accept(this);
		stylesheetNode.getPages().accept(this);
		return null;
	}
	
	public abstract T visit(Checkbox checkboxNode);
	public abstract T visit(Dropdown dropdownNode);
	public abstract T visit(RadioButton radioButtonNode);
	public abstract T visit(TextField textFieldNode);
	public abstract T visit(Spinbox spinnerNode);
	public abstract T visit(Slider sliderNode);
	public abstract T visit(DefaultWidget defaultWidget);

	public abstract T visit(StyleRule styleRuleNode);
	public T visit(StyleRuleSet styleRuleSetNode) {
		for(StyleRule rule : styleRuleSetNode.rules()) {
			rule.accept(this);
		}
		return null;
	}
	
	public T visit(ValueSet valueSetNode) {
		for(Literal<?> value : valueSetNode.values()) {
			value.accept(this);
		}
		return null;
	}


	public T visit(Default defaultNode) {
		defaultNode.getType().accept(this);
		defaultNode.getStyleRuleSet().accept(this);
		defaultNode.getWidget().accept(this);
		return null;
	}


	public abstract T visit(Color color);
	public abstract T visit(Width width);
	public abstract T visit(Height height);
	public abstract T visit(Font font);
	public abstract T visit(FontSize fontSize);
}