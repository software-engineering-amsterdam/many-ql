package org.uva.sea.ql.encoders.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.BinaryExpression;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.QLBoolean;
import org.uva.sea.ql.encoders.ast.type.QLUndefined;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class TypeCheckerVisitor extends BaseAstVisitor<DataType> {

	private Set<String> questionLabels = new HashSet<>();

	private Set<String> questionNames = new HashSet<String>();

	private List<Validation> validations = new ArrayList<>();

	private List<Question> questions = new ArrayList<>();

	private QuestionByName questionByName = new QuestionByName();

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
			if (!(dataType instanceof QLBoolean)) {
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

		Question question = questionByName.getQuestion(name, questions);
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
			return QLUndefined.UNDEFINED;
		}
	}

	@Override
	public DataType visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		DataType leftHandDataType = leftHand.accept(this);
		DataType rightHandDataType = rightHand.accept(this);
		if (leftHandDataType.equals(QLUndefined.UNDEFINED) || rightHandDataType.equals(QLUndefined.UNDEFINED)) {
			return QLUndefined.UNDEFINED;
		}
		if (leftHandDataType.equals(rightHandDataType)) {
			return leftHandDataType;
		}
		TextLocation textLocation = binaryExpression.getTextLocation();
		String validationMessage = "DataTypes of OperatorExpression do not match! lefthand datatype=" + leftHandDataType
				+ " righthand datatype=" + rightHandDataType;
		validations.add(new Validation(validationMessage, textLocation));
		return QLUndefined.UNDEFINED;
	}

}
