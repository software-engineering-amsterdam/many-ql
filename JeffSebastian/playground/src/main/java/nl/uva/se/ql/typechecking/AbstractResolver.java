package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.ast.expression.Binary;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;
import nl.uva.se.ql.ast.expression.Unary;
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

public class AbstractResolver implements FormVisitor, StatementVisitor, ExpressionVisitor<Void> {
	
	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		calculatedQuestion.getExpression().accept(this);
	}

	public void visit(Condition condition) {
		condition.visitChildren(this);
	}

	public Void visit(Addition plus) {
		visitBinaryExpression(plus);
		return null;
	}

	public Void visit(Divide divide) {
		visitBinaryExpression(divide);
		return null;
	}

	public Void visit(Power power) {
		visitBinaryExpression(power);
		return null;
	}

	public Void visit(Multiply multiply) {
		visitBinaryExpression(multiply);
		return null;
	}

	public Void visit(Modulo modulo) {
		visitBinaryExpression(modulo);
		return null;
	}

	public Void visit(Negative negative) {
		visitUnaryExpression(negative);
		return null;
	}

	public Void visit(Positive positive) {
		visitUnaryExpression(positive);
		return null;
	}

	public Void visit(Substraction minus) {
		visitBinaryExpression(minus);
		return null;
	}

	public Void visit(Not not) {
		visitUnaryExpression(not);
		return null;
	}

	public Void visit(NotEqual notEqual) {
		visitBinaryExpression(notEqual);
		return null;
	}

	public Void visit(Or or) {
		visitBinaryExpression(or);
		return null;
	}

	public Void visit(LessThen lessThen) {
		visitBinaryExpression(lessThen);
		return null;
	}

	public Void visit(LessOrEqual lessOrEqual) {
		visitBinaryExpression(lessOrEqual);
		return null;
	}

	public Void visit(GreaterThen greaterThen) {
		visitBinaryExpression(greaterThen);
		return null;
	}

	public Void visit(GreaterOrEqual greaterOrEqual) {
		visitBinaryExpression(greaterOrEqual);
		return null;
	}

	public Void visit(Equal equal) {
		visitBinaryExpression(equal);
		return null;
	}

	public Void visit(And and) {
		visitBinaryExpression(and);
		return null;
	}

	public Void visit(BooleanLiteral booleanLiteral) {
		return null;
	}

	public Void visit(DecimalLiteral decimalLiteral) {
		return null;
	}

	public Void visit(IntegerLiteral integerLiteral) {
		return null;
	}

	public Void visit(StringLiteral stringLiteral) {
		return null;
	}

	public Void visit(Reference reference) {
		return null;
	}
	
	private void visitBinaryExpression(Binary expr) {
		expr.getLeft().accept(this);
		expr.getRight().accept(this);
	}
	
	private void visitUnaryExpression(Unary expr) {
		expr.getSingleExpression().accept(this);
	}
}
