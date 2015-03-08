package org.uva.sea.ql.encoders.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.OperatorExpression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.TextLocation;

public class TypeCheckerVisitor extends BaseAstVisitor<DataType> {

	private Set<String> questionLabels = new HashSet<>();

	private Set<String> questionNames = new HashSet<String>();

	private List<Validation> validations = new ArrayList<>();

	private List<Question> questions = new ArrayList<>();

	public TypeCheckerVisitor(List<Question> questions) {
		this.questions = questions;
	}

	public List<Validation> checkTypes() {
		for (Question question : questions) {
			questionNames.add(question.getName());
			checkForDuplicateLabel(question);
			checkDataTypes(question);
		}
		return validations;
	}

	private void checkDataTypes(Question question) {
		Expression condition = question.getCondition();
		if (condition != null) {
			DataType dataType = condition.accept(this);
			if (!dataType.equals(DataType.BOOLEAN)) {
				TextLocation textLocation = condition.getTextLocation();
				String validationMessage = "Condition has to be of type boolean. Type: " + dataType;
				validations.add(new Validation(validationMessage, textLocation));
			}
		}
		Expression computed = question.getComputed();
		if (computed != null) {
			computed.accept(this);
		}
	}

	private void checkForDuplicateLabel(Question question) {
		String label = question.getQuestionText();
		boolean added = questionLabels.add(label);
		if (!added) {
			validations.add(new Validation("Duplicate label: " + label, question.getTextLocation()));
		}
	}

	@Override
	public DataType visit(BracedExpression bracedExpression) {
		Expression innerExpression = bracedExpression.getExpression();
		return innerExpression.accept(this);
	}

	@Override
	public DataType visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		Question question = getQuestion(name);
		if (question != null) {
			if (!questionNames.contains(name)) {
				String validationMessage = "Reference may only be listed after the question it references. Question: " + name;
				TextLocation textLocation = nameExpression.getTextLocation();
				validations.add(new Validation(validationMessage, textLocation));
			}
			return question.getDataType();
		} else {
			String validationMessage = "Reference to undefined question: " + name;
			TextLocation textLocation = nameExpression.getTextLocation();
			validations.add(new Validation(validationMessage, textLocation));
			return DataType.UNDEFINED;
		}
	}

	@Override
	public DataType visit(OperatorExpression operatorExpression) {
		Expression leftHand = operatorExpression.getLeftHand();
		Expression rightHand = operatorExpression.getRightHand();
		DataType leftHandDataType = leftHand.accept(this);
		DataType rightHandDataType = rightHand.accept(this);
		if (leftHandDataType.equals(DataType.UNDEFINED) || rightHandDataType.equals(DataType.UNDEFINED)) {
			return DataType.UNDEFINED;
		}
		if (leftHandDataType.equals(rightHandDataType)) {
			return leftHandDataType;
		}
		TextLocation textLocation = operatorExpression.getTextLocation();
		String validationMessage = "DataTypes of OperatorExpression do not match! lefthand datatype=" + leftHandDataType
				+ " righthand datatype=" + rightHandDataType;
		validations.add(new Validation(validationMessage, textLocation));
		return DataType.UNDEFINED;
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
