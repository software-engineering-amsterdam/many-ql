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

	private Set<String> questionLabels = new HashSet<>();

	private Set<String> questionNames = new HashSet<String>();

	public List<Validation> checkTypes(List<Question> questions) {
		List<Validation> validations = new ArrayList<>();
		for (Question question : questions) {
			questionNames.add(question.getName());
			checkForDuplicateLabel(question, validations);
			checkDataTypes(questions, validations, question);
		}
		return validations;
	}

	private void checkDataTypes(List<Question> questions,
			List<Validation> validations, Question question) {
		Expression condition = question.getCondition();
		if (condition != null) {
			DataType dataType = determineDataType(condition, validations,
					questions);
			if (!dataType.equals(DataType.BOOLEAN)) {
				TextLocation textLocation = condition.getTextLocation();
				String validationMessage = "Condition has to be of type boolean. Type: "
						+ dataType;
				validations.add(new Validation(validationMessage,
						textLocation));
			}
		}
		Expression computed = question.getComputed();
		if (computed != null) {
			determineDataType(computed, validations, questions);
		}
	}

	private void checkForDuplicateLabel(Question question,
			List<Validation> validations) {
		String label = question.getQuestionText();
		boolean added = questionLabels.add(label);
		if (!added) {
			validations.add(new Validation("Duplicate label: " + label,
					question.getTextLocation()));
		}
	}

	private DataType determineDataType(Expression expression,
			List<Validation> validations, List<Question> questions) {
		if (expression instanceof NameExpression) {
			String name = ((NameExpression) expression).getName();
			Question question = getQuestion(name, questions);
			if (question != null) {
				if (!questionNames.contains(name)) {
					String validationMessage = "Reference may only be listed after the question it references. Question: "
							+ name;
					TextLocation textLocation = expression.getTextLocation();
					validations.add(new Validation(validationMessage,
							textLocation));
				}
				return question.getDataType();
			} else {
				String validationMessage = "Reference to undefined question: "
						+ name;
				TextLocation textLocation = expression.getTextLocation();
				validations.add(new Validation(validationMessage,
						textLocation));
				return DataType.UNDEFINED;
			}
		}
		if (expression instanceof BracedExpression) {
			Expression innerExpression = ((BracedExpression) expression)
					.getExpression();
			return determineDataType(innerExpression, validations,
					questions);
		}
		if (expression instanceof OperatorExpression) {
			OperatorExpression operatorExpression = (OperatorExpression) expression;
			Expression leftHand = operatorExpression.getLeftHand();
			Expression rightHand = operatorExpression.getRightHand();
			DataType leftHandDataType = determineDataType(leftHand,
					validations, questions);
			DataType rightHandDataType = determineDataType(rightHand,
					validations, questions);
			if (leftHandDataType.equals(DataType.UNDEFINED)
					|| rightHandDataType.equals(DataType.UNDEFINED)) {
				return DataType.UNDEFINED;
			}
			if (leftHandDataType.equals(rightHandDataType)) {
				return leftHandDataType;
			}
			TextLocation textLocation = expression.getTextLocation();
			String validationMessage = "DataTypes of OperatorExpression do not match! lefthand datatype="
					+ leftHandDataType
					+ " righthand datatype="
					+ rightHandDataType;
			validations.add(new Validation(validationMessage,
					textLocation));
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
