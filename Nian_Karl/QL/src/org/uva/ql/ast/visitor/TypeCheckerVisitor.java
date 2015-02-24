package org.uva.ql.ast.visitor;

import org.uva.ql.ast.expression.association.Parenthese;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Minus;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Plus;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.BlockStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.type.ExpressionType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.QuestionType;

public class TypeCheckerVisitor implements Visitor<Boolean> {

	@Override
	public Boolean visit(IfStatement ifStatement) {
		return null;
	}

	@Override
	public Boolean visit(QuestionNormal questionStatement) {
		return null;
	}

	@Override
	public Boolean visit(BlockStatement blockStatement) {
		return null;
	}

	@Override
	public Boolean visit(Form form) {
		return null;
	}

	@Override
	public Boolean visit(Questionnaire questionnaire) {
		return null;
	}

	@Override
	public Boolean visit(Not node) {
		return null;
	}

	@Override
	public Boolean visit(Positive node) {
		return null;
	}

	@Override
	public Boolean visit(Negative node) {
		return null;
	}

	@Override
	public Boolean visit(Plus node) {
		
		return null;
	}

	@Override
	public Boolean visit(Minus node) {
		return null;
	}

	@Override
	public Boolean visit(Multiply node) {
		return null;
	}

	@Override
	public Boolean visit(Divide node) {
		return null;
	}

	@Override
	public Boolean visit(And node) {
		return null;
	}

	@Override
	public Boolean visit(Or node) {
		return null;
	}

	@Override
	public Boolean visit(Equal node) {
		return null;
	}

	@Override
	public Boolean visit(NotEqual node) {
		return null;
	}

	@Override
	public Boolean visit(Greater node) {
		return null;
	}

	@Override
	public Boolean visit(GreaterEqual node) {
		return null;
	}

	@Override
	public Boolean visit(Less node) {
		
		return null;
	}

	@Override
	public Boolean visit(LessEqual node) {
		return null;
	}

	@Override
	public Boolean visit(Identifier node) {
		return null;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return null;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Boolean visit(StrLiteral node) {
		return null;
	}

	@Override
	public Boolean visit(Parenthese node) {
		return null;
	}

	@Override
	public Boolean visit(IntType node) {
		
		return null;
	}

}
