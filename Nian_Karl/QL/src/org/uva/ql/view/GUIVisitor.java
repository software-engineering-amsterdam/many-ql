package org.uva.ql.view;

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
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.visitor.Visitor;

public class GUIVisitor implements Visitor<Object> {

	private Questionnaire questionnaire;

	public GUIVisitor(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	@Override
	public Object visit(IfStatement ifStatement) {
		return null;
	}

	@Override
	public Object visit(QuestionNormal questionStatement) {
		return null;
	}

	@Override
	public Object visit(QuestionCompute questionComputeStatement) {
		return null;
	}

	
	@Override
	public Object visit(Block blockStatement) {
		return null;
	}

	@Override
	public Object visit(Form form) {
		
		return null;
	}

	@Override
	public Object visit(Questionnaire questionnaire) {
		return null;
	}

	@Override
	public Object visit(Not node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Positive node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Negative node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Plus node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Minus node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Multiply node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Divide node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(And node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Or node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Equal node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotEqual node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Greater node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GreaterEqual node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Less node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LessEqual node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Identifier node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BoolLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StrLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Parenthese node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IntType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BoolType node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(StrType node) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
