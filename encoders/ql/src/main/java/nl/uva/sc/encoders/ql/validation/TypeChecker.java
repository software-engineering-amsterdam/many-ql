package nl.uva.sc.encoders.ql.validation;

import static nl.uva.sc.encoders.ql.message.Messages.getString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.StringLiteral;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;
import nl.uva.sc.encoders.ql.ast.type.UndefinedType;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

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
