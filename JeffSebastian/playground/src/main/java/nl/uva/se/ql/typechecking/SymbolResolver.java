package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.ast.expression.ExpressionVisitor;
import nl.uva.se.ql.ast.expression.arithmetical.Addition;
import nl.uva.se.ql.ast.expression.arithmetical.Divide;
import nl.uva.se.ql.ast.expression.arithmetical.Modulo;
import nl.uva.se.ql.ast.expression.arithmetical.Multiply;
import nl.uva.se.ql.ast.expression.arithmetical.Negative;
import nl.uva.se.ql.ast.expression.arithmetical.Positive;
import nl.uva.se.ql.ast.expression.arithmetical.Power;
import nl.uva.se.ql.ast.expression.arithmetical.Substraction;
import nl.uva.se.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ql.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ql.ast.expression.literal.StringLiteral;
import nl.uva.se.ql.ast.expression.logical.And;
import nl.uva.se.ql.ast.expression.logical.Equal;
import nl.uva.se.ql.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ql.ast.expression.logical.GreaterThen;
import nl.uva.se.ql.ast.expression.logical.LessOrEqual;
import nl.uva.se.ql.ast.expression.logical.LessThen;
import nl.uva.se.ql.ast.expression.logical.Not;
import nl.uva.se.ql.ast.expression.logical.NotEqual;
import nl.uva.se.ql.ast.expression.logical.Or;
import nl.uva.se.ql.ast.expression.variable.Reference;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.ast.type.Type;
import nl.uva.se.ql.interpretation.Result;
import nl.uva.se.ql.interpretation.error.DuplicateLabels;
import nl.uva.se.ql.interpretation.error.ErrorList;
import nl.uva.se.ql.interpretation.error.IncompatibleTypeDeclaration;
import nl.uva.se.ql.interpretation.error.UndefinedReference;

public class SymbolResolver implements FormVisitor, StatementVisitor, ExpressionVisitor<Void> {

	private SymbolTable symbols;
	private ErrorList errors;

	private SymbolResolver() {
		symbols = new SymbolTable();
		errors = new ErrorList();
	}

	public static Result<SymbolTable> resolve(Form form) {
		SymbolResolver visitor = new SymbolResolver();
		visitor.visit(form);

		return new Result<SymbolTable>(visitor.errors, visitor.symbols);
	}

	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
		addSymbol(question);		
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		addSymbol(calculatedQuestion);
		calculatedQuestion.getExpression().accept(this);
	}

	public void visit(Condition condition) {
		condition.visitChildren(this);
	}
	
	private void addSymbol(Question question) {
		if (symbols.containsSymbol(question.getId())) {
			Type existingType = symbols.getTypeForSymbol(question.getId());
			if (existingType.equals(question.getType())) {
				errors.addWarning(new DuplicateLabels(question.getLineNumber(),
						question.getOffset(), question.getId()));
			} else {
				errors.addError(new IncompatibleTypeDeclaration(symbols
						.getQuestionForSymbol(question.getId()), question));
			}
		} else {
			symbols.addSymbol(question.getId(), question);
		}
	}

	@Override
	public Void visit(Addition plus) {
		plus.getLeft().accept(this);
		plus.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Divide divide) {
		divide.getLeft().accept(this);
		divide.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Power power) {
		power.getLeft().accept(this);
		power.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Multiply multiply) {
		multiply.getLeft().accept(this);
		multiply.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Modulo modulo) {
		modulo.getLeft().accept(this);
		modulo.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Negative negative) {
		negative.getSingleExpression().accept(this);
		return null;
	}

	@Override
	public Void visit(Positive positive) {
		positive.getSingleExpression().accept(this);
		return null;
	}

	@Override
	public Void visit(Substraction minus) {
		minus.getLeft().accept(this);
		minus.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Not not) {
		not.getSingleExpression().accept(this);
		return null;
	}

	@Override
	public Void visit(NotEqual notEqual) {
		notEqual.getLeft().accept(this);
		notEqual.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Or or) {
		or.getLeft().accept(this);
		or.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(LessThen lessThen) {
		lessThen.getLeft().accept(this);
		lessThen.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(LessOrEqual lessOrEqual) {
		lessOrEqual.getLeft().accept(this);
		lessOrEqual.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(GreaterThen greaterThen) {
		greaterThen.getLeft().accept(this);
		greaterThen.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(GreaterOrEqual greaterOrEqual) {
		greaterOrEqual.getLeft().accept(this);
		greaterOrEqual.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(Equal equal) {
		equal.getLeft().accept(this);
		equal.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(And and) {
		and.getLeft().accept(this);
		and.getRight().accept(this);
		return null;
	}

	@Override
	public Void visit(BooleanLiteral booleanLiteral) {
		return null;
	}

	@Override
	public Void visit(DecimalLiteral decimalLiteral) {
		return null;
	}

	@Override
	public Void visit(IntegerLiteral integerLiteral) {
		return null;
	}

	@Override
	public Void visit(StringLiteral stringLiteral) {
		return null;
	}

	@Override
	public Void visit(Reference reference) {
		if (!symbols.containsSymbol(reference.getName())) {
			errors.addError(new UndefinedReference(reference.getLineNumber(), 
					reference.getOffset(), reference.getName()));
		}
		return null;
	}

}
