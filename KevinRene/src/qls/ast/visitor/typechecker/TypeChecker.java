package qls.ast.visitor.typechecker;

import ql.TypeEnvironment;
import ql.ast.visitor.ExpressionVisitor;
import ql.error.TypeErrors;
import qls.ast.QLSStatement;
import qls.ast.stylerule.StyleRule;
import qls.ast.stylerule.property.Color;
import qls.ast.stylerule.property.Font;
import qls.ast.stylerule.property.FontSize;
import qls.ast.stylerule.property.Height;
import qls.ast.stylerule.property.Width;
import qls.ast.visitor.QLSVisitor;
import qls.ast.widget.Checkbox;
import qls.ast.widget.DefaultWidget;
import qls.ast.widget.Dropdown;
import qls.ast.widget.RadioButton;
import qls.ast.widget.Slider;
import qls.ast.widget.Spinner;
import qls.ast.widget.TextField;

public class TypeChecker extends QLSVisitor<Void> implements ExpressionVisitor<Void> {
	private static TypeErrors typeErrors;
	private TypeEnvironment typeEnv;
	
	private TypeChecker(TypeEnvironment typeEnv) {
		this.typeEnv = typeEnv;
		super.setExpressionVisitor(this);
	}
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static boolean check(QLSStatement tree, TypeEnvironment typeEnv) {
		TypeChecker typeChecker = new TypeChecker(typeEnv);
		typeErrors = new TypeErrors();
		
		tree.accept(typeChecker);
		
		typeErrors.outputErrors();
		
		return typeErrors.hasErrors();
	}
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static boolean check(QLSStatement tree, TypeEnvironment typeEnv, TypeErrors errors) {
		TypeChecker typeChecker = new TypeChecker(typeEnv);
		
		typeErrors = errors;
		
		tree.accept(typeChecker);
		
		typeErrors.outputErrors();
		
		return typeErrors.hasErrors();
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
	public Void visit(Spinner spinnerNode) {
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
