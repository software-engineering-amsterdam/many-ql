package nl.uva.sc.encoders.ql.validation;

import static nl.uva.sc.encoders.ql.ast.ConditionalBlockBuilder.aConditionalBlock;
import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.QuestionnaireBuilder.aQuestionnaire;
import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.AndOperator;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;

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
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage, is(notNullValue()));
		assertThat(validationMessage.getValidationMessage(),
				is("Condition has to be of type boolean. Type encountered is 'integer'"));
		assertThat(validations.toString(), validations.size(), is(1));
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
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage, is(notNullValue()));
		assertThat(validationMessage.getValidationMessage(), is("Duplicate label 'What is the meaning of life?'"));
		assertThat(validations.toString(), validations.size(), is(1));
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
		statements.add(aConditionalBlock().withCondition(condition).build());
		statements.add(question);
		Questionnaire questionnaire = aQuestionnaire().withStatements(statements).build();
		TypeChecker typeChecker = new TypeChecker(questionnaire);

		List<TypeValidation> validations = typeChecker.checkTypes();
		TypeValidation typeValidation = validations.get(0);
		assertThat(typeValidation.getValidationMessage(),
				is("Reference may only be listed after the question it references. Question: lateQuestion"));
		assertThat(validations.toString(), validations.size(), is(1));
	}

}
