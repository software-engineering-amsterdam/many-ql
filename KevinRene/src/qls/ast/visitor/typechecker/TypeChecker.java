package qls.ast.visitor.typechecker;

import java.util.ArrayList;
import java.util.List;

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
import qls.ast.statement.DefaultWidget;
import qls.ast.statement.Page;
import qls.ast.statement.Question;
import qls.ast.statement.Stylesheet;
import qls.ast.statement.styling.property.Color;
import qls.ast.statement.styling.property.Font;
import qls.ast.statement.styling.property.FontSize;
import qls.ast.statement.styling.property.Height;
import qls.ast.statement.styling.property.Width;
import qls.ast.visitor.ExpressionVisitor;
import qls.ast.visitor.StatementVisitor;
import qls.errorhandling.error.IllegalPropertyValueError;
import qls.errorhandling.error.IncompatibleWidgetError;
import qls.errorhandling.error.MissingIdentifiersError;
import qls.errorhandling.error.StylesheetIdentifierError;

public class TypeChecker extends StatementVisitor<Void> implements ExpressionVisitor<QLType>, TypeVisitor<Void> {
	private ErrorEnvironment errorEnvironment;
	private TypeEnvironment typeEnvironment;
	private List<Identifier> processedIdentifiers;
	
	private TypeChecker(TypeEnvironment typeEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.typeEnvironment = typeEnvironment;
		errorEnvironment = new ErrorEnvironment();
		processedIdentifiers = new ArrayList<Identifier>();
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
	public Void visit(DefaultWidget defaultNode) {
		if(!defaultNode.getWidget().isCompatibleWith(defaultNode.getType())) {
			errorEnvironment.addError(new IncompatibleWidgetError(defaultNode,
					defaultNode.getType(), defaultNode.getWidget()));
		}
		
		return super.visit(defaultNode);
	}

	@Override
	public QLType visit(Identifier identifierNode) {
		if(processedIdentifiers.contains(identifierNode)) {
			System.out.println("Double usage.");
		}
		
		processedIdentifiers.add(identifierNode);
		return typeEnvironment.resolve(identifierNode);
	}
	
	@Override
	public Void visit(Page pageNode) {
		pageNode.getIdentifier().accept(this);
		return pageNode.getStatements().accept(this);
	}
	
	@Override
	public Void visit(Question questionNode) {
		QLType identifierType = questionNode.getIdentifier().accept(this);
		
		if(!questionNode.hasCompatibleWidget(identifierType)) {
			errorEnvironment.addError(new IncompatibleWidgetError(questionNode,
					identifierType, questionNode.getWidget()));
		}
		
		return questionNode.getWidget().accept(this);
	}
	
	@Override
	public Void visit(Stylesheet stylesheetNode) {
		QLType resolvedType = stylesheetNode.getIdentifier().accept(this);
		
		if(resolvedType == null || !resolvedType.equals(new QLForm())) {
			errorEnvironment.addError(new StylesheetIdentifierError(stylesheetNode, resolvedType));
		}
		
		stylesheetNode.getPages().accept(this);
		
		if(!processedIdentifiers.containsAll(typeEnvironment.getIdentifiers())) {
			errorEnvironment.addError(new MissingIdentifiersError(stylesheetNode, 
					processedIdentifiers, typeEnvironment.getIdentifiers()));
		}
		
		return null;
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
