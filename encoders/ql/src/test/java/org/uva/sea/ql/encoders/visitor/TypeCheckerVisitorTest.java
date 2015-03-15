package org.uva.sea.ql.encoders.visitor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.uva.sea.ql.encoders.ast.QuestionBuilder.aQuestion;
import static org.uva.sea.ql.encoders.ast.TextLocationBuilder.aTextLocation;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.encoders.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.encoders.validation.Validation;

public class TypeCheckerVisitorTest {

	private TypeCheckerVisitor visitor;

	@Test
	public void testCheckTypes_conditionsWithBooleansAreAllowed() {
		Expression leftHand = new BooleanLiteral(aTextLocation().build(), true);
		Expression rightHand = new BooleanLiteral(aTextLocation().build(), true);
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, "&&");
		Question question = aQuestion().withCondition(condition).build();
		List<Question> questions = Arrays.asList(question);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_conditionsWithIntegersAreNotAllowed() {
		Expression leftHand = new IntegerLiteral(aTextLocation().build(), 0);
		Expression rightHand = new IntegerLiteral(aTextLocation().build(), 1);
		Expression condition = new BinaryExpression(aTextLocation().build(), leftHand, rightHand, "&&");
		Question question = aQuestion().withCondition(condition).build();
		List<Question> questions = Arrays.asList(question);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		Validation validation = validations.get(0);
		assertThat(validation, is(notNullValue()));
		assertThat(validation.getValidationMessage(), is("Condition has to be of type boolean. Type encountered is 'integer'"));
	}

	@Test
	public void testCheckTypes_duplicateLabelsAreNotAllowed() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = aQuestion().withQuestionLabel(questionLabel).build();
		Question questionB = aQuestion().withQuestionLabel(questionLabel).build();
		List<Question> questions = Arrays.asList(questionA, questionB);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		Validation validation = validations.get(0);
		assertThat(validation, is(notNullValue()));
		assertThat(validation.getValidationMessage(), is("Duplicate label 'What is the meaning of life?'"));
	}

	@Test
	public void testCheckTypes_differentLabelsAreAllowed() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = aQuestion().withQuestionLabel(questionLabel).build();
		Question questionB = aQuestion().withQuestionLabel(questionLabel + "2").build();
		List<Question> questions = Arrays.asList(questionA, questionB);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

}
