package qls.ast.visitor.typechecker;

import ql.TypeEnvironment;
import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Identifier;
import ql.ast.type.QLForm;
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
import qls.ast.statement.styling.property.Color;
import qls.ast.statement.styling.property.Font;
import qls.ast.statement.styling.property.FontSize;
import qls.ast.statement.styling.property.Height;
import qls.ast.statement.styling.property.Width;
import qls.ast.statement.widget.type.Checkbox;
import qls.ast.statement.widget.type.Default;
import qls.ast.statement.widget.type.Dropdown;
import qls.ast.statement.widget.type.RadioButton;
import qls.ast.statement.widget.type.Slider;
import qls.ast.statement.widget.type.Spinbox;
import qls.ast.statement.widget.type.TextField;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.StatementVisitor;
import qls.errorhandling.error.IllegalPropertyValueError;
import qls.errorhandling.error.StylesheetIdentifierError;

public class TypeChecker extends StatementVisitor<Void> implements ExpressionVisitor<QLType>, TypeVisitor<Void> {
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
	 */
	public static ErrorEnvironment check(QLSStatement tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		tree.accept(typeChecker);
		
		return typeChecker.getErrorEnvironment();
	}
	
	public static ErrorEnvironment check(Expression tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		tree.accept(typeChecker);
		
		return typeChecker.getErrorEnvironment();
	}
	
	public static ErrorEnvironment check(QLType tree, TypeEnvironment typeEnvironment) {
		TypeChecker typeChecker = new TypeChecker(typeEnvironment);
		
		tree.accept(typeChecker);
		
		return typeChecker.getErrorEnvironment();
	}
	
	@Override
	public QLType visit(Identifier identifierNode) {
		return typeEnvironment.resolve(identifierNode);
	}
	
	@Override
	public Void visit(Page pageNode) {
		pageNode.getIdentifier().accept(this);
		return pageNode.getStatements().accept(this);
	}
	
	@Override
	public Void visit(QLSBlock blockNode) {
		super.visit(blockNode);
		return null;
	}
	
	@Override
	public Void visit(Question questionNode) {
		super.visit(questionNode);
		return null;
	}
	
	@Override
	public Void visit(Section sectionNode) {
		super.visit(sectionNode);
		return null;
	}
	
	@Override
	public Void visit(Stylesheet stylesheetNode) {
		QLType resolvedType = stylesheetNode.getIdentifier().accept(this);
		
		if(resolvedType == null || !resolvedType.equals(new QLForm())) {
			errorEnvironment.addError(new StylesheetIdentifierError(stylesheetNode, resolvedType));
		}
		
		return stylesheetNode.getPages().accept(this);
	}
	
	@Override
	public QLType visit(BooleanLiteral booleanLiteral) {
		return booleanLiteral.getType();
	}

	@Override
	public QLType visit(FloatLiteral floatLiteral) {
		return floatLiteral.getType();
	}

	@Override
	public QLType visit(IntegerLiteral integerLiteral) {
		return integerLiteral.getType();
	}
	
	@Override
	public QLType visit(StringLiteral stringLiteral) {
		return stringLiteral.getType();
	}
	
	/*****************
	 * WIDGET TYPES **
	 *****************/
	@Override
	public Void visit(Checkbox checkboxNode) {
		return null;
	}
	
	@Override
	public Void visit(Default defaultType) {
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

	/*********************
	 * STYLE PROPERTIES **
	 *********************/
	@Override
	public Void visit(Color color) {
		QLType valueType = color.getValue().accept(this);
		
		if(!color.isCompatibleWith(valueType)) {
			errorEnvironment.addError(new IllegalPropertyValueError(color, valueType));
		}
		
		return null;
	}

	@Override
	public Void visit(Width width) {
		QLType valueType = width.getValue().accept(this);

		if(!width.isCompatibleWith(valueType)) {
			errorEnvironment.addError(new IllegalPropertyValueError(width, valueType));
		}
		
		return null;
	}

	@Override
	public Void visit(Height height) {
		QLType valueType = height.getValue().accept(this);
		
		if(!height.isCompatibleWith(valueType)) {
			errorEnvironment.addError(new IllegalPropertyValueError(height, valueType));
		}

		return null;
	}

	@Override
	public Void visit(Font font) {
		QLType valueType = font.getValue().accept(this);
		
		if(!font.isCompatibleWith(valueType)) {
			errorEnvironment.addError(new IllegalPropertyValueError(font, valueType));
		}
		
		return null;
	}

	@Override
	public Void visit(FontSize fontSize) {
		QLType valueType = fontSize.getValue().accept(this);
		
		if(!fontSize.isCompatibleWith(valueType)) {
			errorEnvironment.addError(new IllegalPropertyValueError(fontSize, valueType));
		}

		return null;
	}
}
