package org.uva.sea.ql.encoders.validation;

import static org.uva.sea.ql.encoders.message.Messages.getString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.encoders.ast.statement.Question;
import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.ast.type.StringType;
import org.uva.sea.ql.encoders.ast.type.UndefinedType;
import org.uva.sea.ql.encoders.visitor.ExpressionVisitor;

public class TypeChecker implements ExpressionVisitor<DataType> {

	private static final String BOOLEAN_CONDITION = "booleanCondition";
	private static final String DUPLICATE_LABEL = "duplicateLabel";
	private static final String REFERENCE_BEFORE_STATED = "referenceBeforeStated";
	private static final String UNDEFINED_QUESTION = "undefinedQuestion";
	private static final String MATCHING_DATA_TYPES = "matchingDataTypes";

	private Set<String> questionLabels = new HashSet<>();

	private Set<String> questionNames = new HashSet<String>();

	private List<TypeValidation> validations = new ArrayList<>();

	private List<Question> questions = new ArrayList<>();

	public TypeChecker(List<Question> questions) {
		this.questions = questions;
	}

	public List<TypeValidation> checkTypes() {
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
			if (!(dataType instanceof BooleanType)) {
				TextLocation textLocation = condition.getTextLocation();
				String validationMessage = getString(BOOLEAN_CONDITION, dataType);
				validations.add(new TypeValidation(validationMessage, textLocation));
			}
		}
		Expression computed = question.getComputed();
		if (computed != null) {
			computed.accept(this);
		}
	}

	private void checkForDuplicateLabel(Question question) {
		String label = question.getQuestionLabel();
		boolean added = questionLabels.add(label);
		if (!added) {
			String validationMessage = getString(DUPLICATE_LABEL, label);
			validations.add(new TypeValidation(validationMessage, question.getTextLocation()));
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

		Question question = getQuestion(name, questions);
		if (question != null) {
			if (!questionNames.contains(name)) {
				String validationMessage = getString(REFERENCE_BEFORE_STATED, name);
				TextLocation textLocation = nameExpression.getTextLocation();
				validations.add(new TypeValidation(validationMessage, textLocation));
			}
			return question.getDataType();
		} else {
			String validationMessage = getString(UNDEFINED_QUESTION, name);
			TextLocation textLocation = nameExpression.getTextLocation();
			validations.add(new TypeValidation(validationMessage, textLocation));
			return UndefinedType.UNDEFINED;
		}
	}

	private Question getQuestion(String name, List<Question> questions) {
		for (Question question : questions) {
			if (questionHasName(question, name)) {
				return question;
			}
		}
		return null;
	}

	private boolean questionHasName(Question question, String name) {
		return name.equals(question.getName());
	}

	@Override
	public DataType visit(UnaryExpression unaryExpression) {
		Expression expression = unaryExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public DataType visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		DataType leftHandDataType = leftHand.accept(this);
		DataType rightHandDataType = rightHand.accept(this);
		if (leftHandDataType.equals(UndefinedType.UNDEFINED) || rightHandDataType.equals(UndefinedType.UNDEFINED)) {
			return UndefinedType.UNDEFINED;
		}
		if (leftHandDataType.equals(rightHandDataType)) {
			return leftHandDataType;
		}
		TextLocation textLocation = binaryExpression.getTextLocation();
		String validationMessage = getString(MATCHING_DATA_TYPES, leftHandDataType, rightHandDataType);
		validations.add(new TypeValidation(validationMessage, textLocation));
		return UndefinedType.UNDEFINED;
	}

	@Override
	public DataType visit(IntegerLiteral integerLiteral) {
		return new IntegerType();
	}

	@Override
	public DataType visit(StringLiteral stringLiteral) {
		return new StringType();
	}

	@Override
	public DataType visit(BooleanLiteral booleanLiteral) {
		return new BooleanType();
	}
}
