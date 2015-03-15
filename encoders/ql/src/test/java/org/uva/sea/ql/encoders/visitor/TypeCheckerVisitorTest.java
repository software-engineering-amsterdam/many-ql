package org.uva.sea.ql.encoders.visitor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.uva.sea.ql.encoders.ast.QuestionBuilder.question;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BooleanExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.IntegerExpression;
import org.uva.sea.ql.encoders.validation.Validation;

public class TypeCheckerVisitorTest {

	private TypeCheckerVisitor visitor;

	@Test
	public void testCheckTypes_conditionsWithBooleansAreAllowed() {
		Expression leftHand = new BooleanExpression(new TextLocation(10, 10), true);
		Expression rightHand = new BooleanExpression(new TextLocation(10, 10), true);
		Expression condition = new BinaryExpression(new TextLocation(8, 0), leftHand, rightHand, "&&");
		Question question = question().withCondition(condition).build();
		List<Question> questions = Arrays.asList(question);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_conditionsWithIntegersAreNotAllowed() {
		Expression leftHand = new IntegerExpression(new TextLocation(10, 10), 0);
		Expression rightHand = new IntegerExpression(new TextLocation(10, 10), 1);
		Expression condition = new BinaryExpression(new TextLocation(8, 0), leftHand, rightHand, "&&");
		Question question = question().withCondition(condition).build();
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
		Question questionA = question().withQuestionLabel(questionLabel).build();
		Question questionB = question().withQuestionLabel(questionLabel).build();
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
		Question questionA = question().withQuestionLabel(questionLabel).build();
		Question questionB = question().withQuestionLabel(questionLabel + "2").build();
		List<Question> questions = Arrays.asList(questionA, questionB);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

}
