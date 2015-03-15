package org.uva.sea.ql.encoders.visitor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BooleanExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.IntegerExpression;
import org.uva.sea.ql.encoders.ast.type.StringType;
import org.uva.sea.ql.encoders.validation.Validation;

public class TypeCheckerVisitorTest {

	private TypeCheckerVisitor visitor;

	@Test
	public void testCheckTypes_conditionsWithBooleansAreAllowed() {
		String questionLabel = "Depends on this and that";
		Question questionA = new Question(new TextLocation(10, 10), "questionA", new StringType(), questionLabel);
		Expression leftHand = new BooleanExpression(new TextLocation(10, 10), true);
		Expression rightHand = new BooleanExpression(new TextLocation(10, 10), true);
		Expression condition = new BinaryExpression(new TextLocation(8, 0), leftHand, rightHand, "&&");
		questionA.setCondition(condition);
		List<Question> questions = Arrays.asList(questionA);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

	@Test
	public void testCheckTypes_conditionsWithIntegersAreNotAllowed() {
		String questionLabel = "Depends on this and that";
		Question questionA = new Question(new TextLocation(10, 10), "questionA", new StringType(), questionLabel);
		Expression leftHand = new IntegerExpression(new TextLocation(10, 10), 0);
		Expression rightHand = new IntegerExpression(new TextLocation(10, 10), 1);
		Expression condition = new BinaryExpression(new TextLocation(8, 0), leftHand, rightHand, "&&");
		questionA.setCondition(condition);
		List<Question> questions = Arrays.asList(questionA);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		Validation validation = validations.get(0);
		assertThat(validation, is(notNullValue()));
		assertThat(validation.getValidationMessage(), is("Condition has to be of type boolean. Type encountered is 'integer'"));
	}

	@Test
	public void testCheckTypes_duplicateLabelsAreNotAllowed() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = new Question(new TextLocation(10, 10), "questionA", new StringType(), questionLabel);
		Question questionB = new Question(new TextLocation(12, 10), "questionB", new StringType(), questionLabel);
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
		Question questionA = new Question(new TextLocation(10, 10), "questionA", new StringType(), questionLabel);
		Question questionB = new Question(new TextLocation(12, 10), "questionB", new StringType(), questionLabel + "2");
		List<Question> questions = Arrays.asList(questionA, questionB);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		assertThat(validations.size(), is(0));
	}

}
