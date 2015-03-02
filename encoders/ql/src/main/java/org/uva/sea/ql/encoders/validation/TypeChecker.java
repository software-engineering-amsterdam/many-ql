package org.uva.sea.ql.encoders.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.OperatorExpression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.TextLocation;

public class TypeChecker implements AstVisitor {

	private Set<String> labels = new HashSet<>();

	public List<TypeValidation> checkTypes(List<Question> questions) {
		List<TypeValidation> typeValidations = new ArrayList<>();
		for (Question question : questions) {
			checkForDuplicateLabel(question, typeValidations);
			checkDataTypes(questions, typeValidations, question);
		}
		return typeValidations;
	}

	private void checkDataTypes(List<Question> questions, List<TypeValidation> typeValidations, Question question) {
		Expression condition = question.getCondition();
		if (condition != null) {
			determineDataType(condition, typeValidations, questions);
		}
		Expression computed = question.getComputed();
		if (computed != null) {
			determineDataType(computed, typeValidations, questions);
		}
	}

	private void checkForDuplicateLabel(Question question, List<TypeValidation> typeValidations) {
		String label = question.getQuestionText();
		boolean added = labels.add(label);
		if (!added) {
			typeValidations.add(new TypeValidation("Duplicate label: " + label, question.getTextLocation()));
		}
	}

	private DataType determineDataType(Expression expression, List<TypeValidation> typeValidations, List<Question> questions) {
		if (expression instanceof NameExpression) {
			String name = ((NameExpression) expression).getName();
			Question question = getQuestion(name, questions);
			if (question != null) {
				return question.getDataType();
			} else {
				String validationMessage = "Reference to undefined question: " + name;
				TextLocation textLocation = expression.getTextLocation();
				typeValidations.add(new TypeValidation(validationMessage, textLocation));
				return DataType.UNDEFINED;
			}
		}
		if (expression instanceof BracedExpression) {
			Expression innerExpression = ((BracedExpression) expression).getExpression();
			return determineDataType(innerExpression, typeValidations, questions);
		}
		if (expression instanceof OperatorExpression) {
			OperatorExpression operatorExpression = (OperatorExpression) expression;
			Expression leftHand = operatorExpression.getLeftHand();
			Expression rightHand = operatorExpression.getRightHand();
			DataType leftHandDataType = determineDataType(leftHand, typeValidations, questions);
			DataType rightHandDataType = determineDataType(rightHand, typeValidations, questions);
			if (leftHandDataType.equals(DataType.UNDEFINED) || rightHandDataType.equals(DataType.UNDEFINED)) {
				return DataType.UNDEFINED;
			}
			if (leftHandDataType.equals(rightHandDataType)) {
				return leftHandDataType;
			}
			TextLocation textLocation = expression.getTextLocation();
			String validationMessage = "DataTypes of OperatorExpression do not match! lefthand datatype=" + leftHandDataType
					+ " righthand datatype=" + rightHandDataType;
			typeValidations.add(new TypeValidation(validationMessage, textLocation));
			return DataType.UNDEFINED;
		}
		throw new RuntimeException("Unsupported type " + expression.getClass());
	}

	private Question getQuestion(String name, List<Question> questions) {
		for (Question question : questions) {
			String questionName = question.getName();
			if (name.equals(questionName)) {
				return question;
			}
		}
		return null;
	}

}
