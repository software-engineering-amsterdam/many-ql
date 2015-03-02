package org.uva.sea.ql.encoders.validation;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.OperatorExpression;
import org.uva.sea.ql.encoders.ast.Question;

public class TypeChecker implements AstVisitor {

	private List<TypeValidation> typeValidations = new ArrayList<TypeValidation>();

	private List<Question> questions = new ArrayList<>();

	public TypeChecker(List<Question> questions) {
		this.questions = questions;
	}

	public List<TypeValidation> checkTypes() {
		for (Question question : questions) {
			Expression condition = question.getCondition();
			if (condition != null) {
				determineDataType(condition);
			}
			Expression computed = question.getComputed();
			if (computed != null) {
				determineDataType(computed);
			}
		}
		return typeValidations;
	}

	private DataType determineDataType(Expression expression) {
		if (expression instanceof NameExpression) {
			String name = ((NameExpression) expression).getName();
			Question question = getQuestion(name);
			if (question != null) {
				return question.getDataType();
			} else {
				throw new IllegalStateException("Unreferenced question: " + name);
			}
		}
		if (expression instanceof BracedExpression) {
			return determineDataType(((BracedExpression) expression).getExpression());
		}
		if (expression instanceof OperatorExpression) {
			OperatorExpression operatorExpression = (OperatorExpression) expression;
			Expression leftHand = operatorExpression.getLeftHand();
			Expression rightHand = operatorExpression.getRightHand();
			DataType leftHandDataType = determineDataType(leftHand);
			DataType rightHandDataType = determineDataType(rightHand);
			if (leftHandDataType.equals(rightHandDataType)) {
				return leftHandDataType;
			}
			typeValidations.add(new TypeValidation("UnequalDataTypes",
					"DataTypes of OperatorExpression do not match! lefthand datatype=" + leftHandDataType + "righthand datatype="
							+ rightHandDataType));
			return DataType.UNDEFINED;
		}
		throw new RuntimeException("Unsupported type " + expression.getClass());
	}

	private Question getQuestion(String name) {
		for (Question question : questions) {
			String questionName = question.getName();
			if (name.equals(questionName)) {
				return question;
			}
		}
		return null;
	}

}
