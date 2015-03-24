package nl.uva.sc.encoders.ql.validation;

import static nl.uva.sc.encoders.ql.message.Messages.getString;
import static nl.uva.sc.encoders.ql.validation.ValidationMessage.Type.ERROR;
import static nl.uva.sc.encoders.ql.validation.ValidationMessage.Type.WARNING;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;
import nl.uva.sc.encoders.ql.ast.operator.BinaryOperator;
import nl.uva.sc.encoders.ql.ast.operator.UnaryOperator;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.TypeMap;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;
import nl.uva.sc.encoders.ql.visitor.StatementVisitor;

public class TypeChecker implements ExpressionVisitor<List<TypeValidation>>, StatementVisitor<List<TypeValidation>> {

	private static final String BOOLEAN_CONDITION = "booleanCondition";
	private static final String DUPLICATE_LABEL = "duplicateLabel";
	private static final String REFERENCE_BEFORE_STATED = "referenceBeforeStated";
	private static final String UNDEFINED_QUESTION = "undefinedQuestion";
	private static final String UNSUPPORTED_TYPES_FOR_BINARY_OPERATOR = "unsupportedTypesForBinaryOperator";
	private static final String UNSUPPORTED_TYPES_FOR_UNARY_OPERATOR = "unsupportedTypesForUnaryOperator";
	private static final String COMPUTED_TYPE_DOES_NOT_MATCH_QUESTION_TYPE = "computedTypeDoesNotMatchQuestionType";

	private final TypeMap typeMap = new TypeMap();

	private final Set<String> questionLabels = new HashSet<>();

	private final Questionnaire questionnaire;

	public TypeChecker(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<TypeValidation> checkTypes() {
		List<TypeValidation> validations = new ArrayList<>();
		List<Statement> statements = questionnaire.getStatements();
		for (Statement statement : statements) {
			validations.addAll(statement.accept(this));
		}
		return validations;
	}

	@Override
	public List<TypeValidation> visit(BracedExpression bracedExpression) {
		Expression innerExpression = bracedExpression.getExpression();
		return innerExpression.accept(this);
	}

	@Override
	public List<TypeValidation> visit(NameExpression nameExpression) {

		List<TypeValidation> validations = new ArrayList<>();
		String name = nameExpression.getName();
		if (!questionnaire.containsQuestion(name)) {
			String validationMessage = getString(UNDEFINED_QUESTION, name);
			TextLocation textLocation = nameExpression.getTextLocation();
			validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
		}
		if (!typeMap.containsKey(name)) {
			String validationMessage = getString(REFERENCE_BEFORE_STATED, name);
			TextLocation textLocation = nameExpression.getTextLocation();
			validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
		}
		return validations;
	}

	@Override
	public List<TypeValidation> visit(UnaryExpression unaryExpression) {
		List<TypeValidation> validations = new ArrayList<>();
		Expression expression = unaryExpression.getExpression();
		validations.addAll(expression.accept(this));
		UnaryOperator operator = unaryExpression.getOperator();
		DataType dataType = expression.getType(typeMap);
		if (!operator.supports(dataType)) {
			String validationMessage = getString(UNSUPPORTED_TYPES_FOR_UNARY_OPERATOR, dataType);
			TextLocation textLocation = unaryExpression.getTextLocation();
			validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
		}
		return validations;
	}

	@Override
	public List<TypeValidation> visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		DataType leftHandDataType = leftHand.getType(typeMap);
		DataType rightHandDataType = rightHand.getType(typeMap);

		List<TypeValidation> validations = new ArrayList<>();
		validations.addAll(leftHand.accept(this));
		validations.addAll(rightHand.accept(this));

		BinaryOperator operator = binaryExpression.getOperator();
		TextLocation textLocation = binaryExpression.getTextLocation();
		if (!operator.supports(leftHandDataType, rightHandDataType)) {
			String validationMessage = getString(UNSUPPORTED_TYPES_FOR_BINARY_OPERATOR, leftHandDataType, rightHandDataType);
			validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
		}
		return validations;
	}

	@Override
	public List<TypeValidation> visit(ConditionalBlock conditionalBlock) {
		List<TypeValidation> validations = new ArrayList<>();
		Expression condition = conditionalBlock.getCondition();
		List<TypeValidation> conditionValidations = condition.accept(this);
		validations.addAll(conditionValidations);
		if (conditionValidations.isEmpty()) {
			DataType dataType = condition.getType(typeMap);
			if (!(dataType instanceof BooleanType)) {
				TextLocation textLocation = condition.getTextLocation();
				String validationMessage = getString(BOOLEAN_CONDITION, dataType);
				validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
			}
		}
		visitQuestions(conditionalBlock.getQuestions());
		return validations;
	}

	private void visitQuestions(List<Question> questions) {
		for (Question question : questions) {
			visit(question);
		}
	}

	@Override
	public List<TypeValidation> visit(Question question) {
		typeMap.put(question.getName(), question.getDataType());
		List<TypeValidation> validations = new ArrayList<>();
		validations.addAll(checkForDuplicateLabel(question));
		validations.addAll(checkDataTypes(question));
		return validations;
	}

	private List<TypeValidation> checkDataTypes(Question question) {
		List<TypeValidation> validations = new ArrayList<>();
		Expression computed = question.getComputed();
		if (computed != null) {
			validations.addAll(computed.accept(this));
			DataType computedType = computed.getType(typeMap);
			DataType questionType = question.getDataType();
			if (!computedType.equals(questionType)) {
				TextLocation textLocation = computed.getTextLocation();
				String validationMessage = getString(COMPUTED_TYPE_DOES_NOT_MATCH_QUESTION_TYPE, computedType, questionType);
				validations.add(new TypeValidation(validationMessage, textLocation, ERROR));
			}
		}
		return validations;
	}

	private List<TypeValidation> checkForDuplicateLabel(Question question) {
		List<TypeValidation> validations = new ArrayList<>();
		String label = question.getQuestionLabel();
		boolean added = questionLabels.add(label);
		if (!added) {
			String validationMessage = getString(DUPLICATE_LABEL, label);
			TextLocation textLocation = question.getTextLocation();
			validations.add(new TypeValidation(validationMessage, textLocation, WARNING));
		}
		return validations;
	}

	@Override
	public List<TypeValidation> visit(LiteralExpression literalExpression) {
		return Collections.emptyList();
	}
}
