package nl.uva.sc.encoders.ql.validation;

import static nl.uva.sc.encoders.ql.ast.ConditionalBlockBuilder.aConditionalBlock;
import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.QuestionnaireBuilder.aQuestionnaire;
import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;
import nl.uva.sc.encoders.ql.ast.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.AndOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.NotOperator;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;

import org.junit.Test;

public class TypeCheckerTest {

	@Test
	public void testCheckTypes_conditionsWithBooleansAreAllowed() {
		Expression leftHand = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(true));
		Expression rightHand = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(true));
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new AndOperator("&&"));
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_conditionsWithIntegersAreNotAllowed() {
		Expression leftHand = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(0));
		Expression rightHand = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(1));
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new AddOperator("+"));
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(1));
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage.getValidationMessage(),
				is("Condition has to be of type boolean. Type encountered is 'integer'"));
	}

	@Test
	public void testCheckTypes_duplicateLabelsAreNotAllowed() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = aQuestion().withQuestionLabel(questionLabel).build();
		Question questionB = aQuestion().withQuestionLabel(questionLabel).build();
		List<Question> questions = Arrays.asList(questionA, questionB);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(1));
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage.getValidationMessage(), is("Duplicate label 'What is the meaning of life?'"));
	}

	@Test
	public void testCheckTypes_differentLabelsAreAllowed() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = aQuestion().withQuestionLabel(questionLabel).build();
		Question questionB = aQuestion().withQuestionLabel(questionLabel + "2").build();
		List<Question> questions = Arrays.asList(questionA, questionB);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_questionThatIsReferencedBeforeItIsListedIsInvalid() {
		String questionName = "lateQuestion";
		Question question = aQuestion().withName(questionName).withQuestionLabel("Ask me later").withDataType(new BooleanType())
				.build();
		List<Statement> statements = new ArrayList<>();
		Expression condition = new NameExpression(aTextLocation().build(), questionName);
		// We add the condition before the question
		statements.add(aConditionalBlock().withCondition(condition).build());
		statements.add(question);
		Questionnaire questionnaire = aQuestionnaire().withStatements(statements).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(1));
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(),
				is("Reference may only be listed after the question it references. Question: lateQuestion"));
	}

	@Test
	public void testCheckTypes_questionThatIsReferencedAfterItIsListedIsValid() {
		String questionName = "onTimeQuestion";
		Question question = aQuestion().withName(questionName).withQuestionLabel("Ask me now").withDataType(new BooleanType())
				.build();
		List<Statement> statements = new ArrayList<>();
		Expression condition = new NameExpression(aTextLocation().build(), questionName);
		// We add the condition after the question
		statements.add(question);
		statements.add(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withStatements(statements).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		assertThat(validations.toString(), validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_questionThatIsUndefinedIsValid() {
		String questionName = "notExistingQuestion";
		List<Statement> statements = new ArrayList<>();
		Expression condition = new NameExpression(aTextLocation().build(), questionName);
		statements.add(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withStatements(statements).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(1));
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(), is("Reference to undefined question 'notExistingQuestion'"));
	}

	@Test
	public void testCheckTypes_questionWithBracedExpressionCanHaveValidations() {
		String existingQuestionName = "existingQuestion";
		Question question = aQuestion().withName(existingQuestionName).withQuestionLabel("Ask me now")
				.withDataType(new BooleanType()).build();
		String notExistingQuestionName = "notExistingQuestion";
		List<Statement> statements = new ArrayList<>();
		Expression leftHand = new NameExpression(aTextLocation().build(), existingQuestionName);
		Expression rightHand = new NameExpression(aTextLocation().build(), notExistingQuestionName);
		Expression binaryExpression = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new AndOperator("&&"));
		Expression condition = new BracedExpression(aTextLocation().build(), binaryExpression);
		statements.add(question);
		statements.add(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withStatements(statements).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(1));
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(), is("Reference to undefined question 'notExistingQuestion'"));
	}

	@Test
	public void testCheckTypes_notOperatorWithIntegerIsNotValid() {
		Expression expression = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(1));
		Expression condition = new UnaryExpression(aTextLocation().build(), new NotOperator("!"), expression);
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(1));
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(), is("Operator does not support operations with datatype integer"));
	}

	@Test
	public void testCheckTypes_notOperatorWithBooleanIsValid() {
		Expression expression = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(true));
		Expression condition = new UnaryExpression(aTextLocation().build(), new NotOperator("!"), expression);
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_greaterThanOperatorWithIntegerIsValid() {
		Expression leftHand = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(3));
		Expression rightHand = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(2));
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new GreaterThanOperator(">"));
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_greaterThanOperatorWithBooleanIsInValid() {
		Expression leftHand = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(true));
		Expression rightHand = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(false));
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new GreaterThanOperator(">"));
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(1));
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(),
				is("Operator does not support operations with lefthand datatype boolean, righthand datatype boolean"));
	}

	@Test
	public void testCheckTypes_computedValueWithDifferentDataTypeThanQuestionIsInvalid() {
		Expression computed = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(5));
		Question question = aQuestion().withDataType(new StringType()).withComputed(computed).build();
		List<Question> questions = Arrays.asList(question);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(1));
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(), is("Computed type integer does not match question type string"));
	}

	@Test
	public void testCheckTypes_computedValueWithSameDataTypeAsQuestionIsValid() {
		Expression computed = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(5));
		Question question = aQuestion().withDataType(new IntegerType()).withComputed(computed).build();
		List<Question> questions = Arrays.asList(question);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_computedValueValidationsAreChecked() {

		Expression literalExpression = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(5));
		Expression computed = new UnaryExpression(aTextLocation().build(), new NotOperator("!"), literalExpression);
		Question question = aQuestion().withDataType(new IntegerType()).withComputed(computed).build();
		List<Question> questions = Arrays.asList(question);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> validations = typeChecker.checkTypes();

		assertThat(validations.toString(), validations.size(), is(1));

		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(), is("Operator does not support operations with datatype integer"));
	}
}
