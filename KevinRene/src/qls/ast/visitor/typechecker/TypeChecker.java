package qls.ast.visitor.typechecker;

import ql.TypeEnvironment;
import ql.ast.visitor.TypeVisitor;
import ql.errorhandling.ErrorEnvironment;
import qls.ast.QLSStatement;
import qls.ast.expression.literal.BooleanLiteral;
import qls.ast.expression.literal.FloatLiteral;
import qls.ast.expression.literal.IntegerLiteral;
import qls.ast.expression.literal.StringLiteral;
import qls.ast.statement.Page;
import qls.ast.statement.QLSBlock;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.stylerule.StyleRule;
import qls.ast.stylerule.property.Color;
import qls.ast.stylerule.property.Font;
import qls.ast.stylerule.property.FontSize;
import qls.ast.stylerule.property.Height;
import qls.ast.stylerule.property.Width;
import qls.ast.visitor.StatementVisitor;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.widget.Checkbox;
import qls.ast.widget.DefaultWidget;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinbox;
import qls.ast.widget.TextField;

public class TypeChecker extends StatementVisitor<Void> implements ExpressionVisitor<Void>, TypeVisitor<Void> {
	private ErrorEnvironment errorEnvironment;
	private TypeEnvironment typeEnvironment;	
	
	private TypeChecker(TypeEnvironment typeEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.typeEnvironment = typeEnvironment;
		errorEnvironment = new ErrorEnvironment();
	}
	
	public ErrorEnvironment getErrorEnvironment() {
		return errorEnvironment;
	}
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static ErrorEnvironment check(QLSStatement tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		tree.accept(typeChecker);
		
		return typeChecker.getErrorEnvironment();
	}
	
	@Override
	public Void visit(Page pageNode) {
		return null;
	}
	
	@Override
	public Void visit(QLSBlock blockNode) {
		return null;
	}
	
	@Override
	public Void visit(Question questionNode) {
		return null;
	}
	
	@Override
	public Void visit(Section sectionNode) {
		return null;
	}
	
	@Override
	public Void visit(Stylesheet stylesheetNode) {
		return null;
	}
	
	@Override
	public Void visit(BooleanLiteral stringLiteral) {
		return null;
	}

	@Override
	public Void visit(FloatLiteral stringLiteral) {
		return null;
	}

	@Override
	public Void visit(IntegerLiteral stringLiteral) {
		return null;
	}
	
	@Override
	public Void visit(StringLiteral stringLiteral) {
		return null;
	}
	
	@Override
	public Void visit(Checkbox checkboxNode) {
		return null;
	}
	
	@Override
	public Void visit(Dropdown dropdownNode) {
		return null;
	}
	
	@Override
	public Void visit(RadioButton radioButtonNode) {
		return null;
	}
	
	@Override
	public Void visit(TextField textFieldNode) {
		return null;
	}
	
	@Override
	public Void visit(Spinbox spinnerNode) {
		return null;
	}
	
	@Override
	public Void visit(Slider sliderNode) {
		return null;
	}
	
	@Override
	public Void visit(DefaultWidget defaultWidget) {
		return null;
	}
	
	@Override
	public Void visit(StyleRule styleRuleNode) {
		return null;
	}

	@Override
	public Void visit(Color color) {
		return null;
	}

	@Override
	public Void visit(Width width) {
		return null;
	}

	@Override
	public Void visit(Height height) {
		return null;
	}

	@Override
	public Void visit(Font font) {
		return null;
	}

	@Override
	public Void visit(FontSize fontSize) {
		return null;
	}	
}
