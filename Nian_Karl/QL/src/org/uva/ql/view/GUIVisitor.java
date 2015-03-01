package org.uva.ql.view;

import java.util.ArrayList;

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
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.visitor.Visitor;

public class GUIVisitor implements Visitor<Object> {

	@Override
	public ComponentView visit(IfStatement ifStatement) {
		return null;
	}

	@Override
	public ComponentView visit(QuestionNormal questionStatement) {
		QuestionView questionView = new QuestionView(questionStatement);
		return questionView;
	}

	@Override
	public ComponentView visit(QuestionCompute questionComputeStatement) {
		return null;
	}

	@Override
	public ArrayList<ComponentView> visit(Block blockStatement) {
		ArrayList<ComponentView> components = new ArrayList<ComponentView>();
		for (Statement statement : blockStatement.getStatements()) {
			components.add((ComponentView) statement.accept(this));
		}
		return components;
	}

	@Override
	public FormView visit(Form form) {
		FormView formView = new FormView();
		ArrayList<ComponentView> components = ((ArrayList<ComponentView>) form.getBlock().accept(this));
		for (ComponentView component : components) {
			formView.getContentPane().add(component);
		}
		formView.setVisible(true);
		return formView;
	}

	@Override
	public Object visit(Questionnaire questionnaire) {
		ArrayList<FormView> formViews = new ArrayList<FormView>();
		for (Form form : questionnaire.getForms()) {
			formViews.add((FormView) form.accept(this));
		}
		return formViews;
	}

	@Override
	public Object visit(Not node) {
		return null;
	}

	@Override
	public Object visit(Positive node) {
		return null;
	}

	@Override
	public Object visit(Negative node) {
		return null;
	}

	@Override
	public Object visit(Plus node) {
		return null;
	}

	@Override
	public Object visit(Minus node) {
		return null;
	}

	@Override
	public Object visit(Multiply node) {
		return null;
	}

	@Override
	public Object visit(Divide node) {
		return null;
	}

	@Override
	public Object visit(And node) {
		return null;
	}

	@Override
	public Object visit(Or node) {
		return null;
	}

	@Override
	public Object visit(Equal node) {
		return null;
	}

	@Override
	public Object visit(NotEqual node) {
		return null;
	}

	@Override
	public Object visit(Greater node) {
		return null;
	}

	@Override
	public Object visit(GreaterEqual node) {
		return null;
	}

	@Override
	public Object visit(Less node) {
		return null;
	}

	@Override
	public Object visit(LessEqual node) {
		return null;
	}

	@Override
	public Object visit(Identifier node) {
		return null;
	}

	@Override
	public Object visit(IntLiteral node) {
		return null;
	}

	@Override
	public Object visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Object visit(StrLiteral node) {
		return null;
	}

	@Override
	public Object visit(Parenthese node) {
		return null;
	}

	@Override
	public Object visit(IntType node) {
		return null;
	}

	@Override
	public Object visit(BoolType node) {
		return null;
	}

	@Override
	public Object visit(StrType node) {
		return null;
	}

}
