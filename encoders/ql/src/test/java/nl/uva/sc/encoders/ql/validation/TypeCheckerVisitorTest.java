package nl.uva.sc.encoders.ql.validation;

import static nl.uva.sc.encoders.ql.ast.ConditionalBlockBuilder.aConditionalBlock;
import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.QuestionnaireBuilder.aQuestionnaire;
import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.AndOperator;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;

import org.junit.Test;

public class TypeCheckerVisitorTest {

	private TypeChecker visitor;

	@Test
	public void testCheckTypes_conditionsWithBooleansAreAllowed() {
		Expression leftHand = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(true));
		Expression rightHand = new LiteralExpression(aTextLocation().build(), new BooleanLiteral(true));
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new AndOperator());
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		visitor = new TypeChecker(questionnaire);

		List<TypeValidation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_conditionsWithIntegersAreNotAllowed() {
		Expression leftHand = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(0));
		Expression rightHand = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(1));
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, new AddOperator());
		List<ConditionalBlock> conditionalBlocks = Arrays.asList(aConditionalBlock().withCondition(condition).build());
		Questionnaire questionnaire = aQuestionnaire().withConditionalBlocks(conditionalBlocks).build();
		visitor = new TypeChecker(questionnaire);

		List<TypeValidation> validations = visitor.checkTypes();
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage, is(notNullValue()));
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
		visitor = new TypeChecker(questionnaire);

		List<TypeValidation> validations = visitor.checkTypes();
		ValidationMessage validationMessage = validations.get(0);
		assertThat(validationMessage, is(notNullValue()));
		assertThat(validationMessage.getValidationMessage(), is("Duplicate label 'What is the meaning of life?'"));
	}

	@Test
	public void testCheckTypes_differentLabelsAreAllowed() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = aQuestion().withQuestionLabel(questionLabel).build();
		Question questionB = aQuestion().withQuestionLabel(questionLabel + "2").build();
		List<Question> questions = Arrays.asList(questionA, questionB);
		Questionnaire questionnaire = aQuestionnaire().withQuestions(questions).build();
		visitor = new TypeChecker(questionnaire);

		List<TypeValidation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

}
