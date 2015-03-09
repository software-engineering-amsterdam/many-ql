package qls.ast.visitor;

import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.widget.Checkbox;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinner;
import qls.ast.widget.TextField;

/**
 * Refused bequest. Who cares?
 * 
 * @author Rene
 */
public abstract class QLSStatementVisitor<T> extends StatementVisitor<T> implements ExpressionVisitor<T> {
	public QLSStatementVisitor() {
		super.setExpressionVisitor(this);
	}
	
	public T visit(Stylesheet stylesheet) {
		stylesheet.getIdentifier().accept(this);	
		stylesheet.getBlock().accept(this);
		return null;
	}
	
	public T visit(Page page) {
		page.accept(this);
		return null;
	}
	
	public abstract T visit(QLSBlock block);
	public abstract T visit(Section section);
	public abstract T visit(Question question);
	
	public abstract T visit(Checkbox checkbox);
	public abstract T visit(Dropdown dropdown);
	public abstract T visit(RadioButton radioButton);
	public abstract T visit(TextField textField);
	public abstract T visit(Spinner spinner);
	public abstract T visit(Slider slider);
}