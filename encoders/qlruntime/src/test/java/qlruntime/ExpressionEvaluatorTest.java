package qlruntime;

import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.literal.IntegerLiteral;
import nl.uva.sc.encoders.ql.ast.literal.StringLiteral;
import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.MultiplyOperator;
import nl.uva.sc.encoders.qlruntime.evaluator.ExpressionEvaluator;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.model.value.IntegerValue;
import nl.uva.sc.encoders.qlruntime.model.value.StringValue;
import nl.uva.sc.encoders.qlruntime.model.value.Value;

import org.junit.Test;

public class ExpressionEvaluatorTest {

	/**
	 * Testing (3 + 7) * 8 = 80
	 */
	@Test
	public void testEvaluatesIntegerExpressions() {
		List<RuntimeQuestion> questions = new ArrayList<>();

		ExpressionEvaluator evaluator = new ExpressionEvaluator(questions);

		LiteralExpression integerThree = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(3));
		LiteralExpression integerSeven = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(7));
		LiteralExpression integerEight = new LiteralExpression(aTextLocation().build(), new IntegerLiteral(8));
		BinaryExpression addExpression = new BinaryExpression(aTextLocation().build(), integerThree, integerSeven, new AddOperator(
				"+"));
		BracedExpression bracedExpression = new BracedExpression(aTextLocation().build(), addExpression);
		BinaryExpression multiplyExpression = new BinaryExpression(aTextLocation().build(), bracedExpression, integerEight,
				new MultiplyOperator("*"));

		Value result = multiplyExpression.accept(evaluator);

		assertThat(result, is(instanceOf(IntegerValue.class)));
		assertThat(((IntegerValue) result).getValue(), is(80));
	}

	/**
	 * Testing "Hi" + " there!" = "Hi there!"
	 */
	@Test
	public void testEvaluatesStringConcatenation() {
		List<RuntimeQuestion> questions = new ArrayList<>();

		ExpressionEvaluator evaluator = new ExpressionEvaluator(questions);

		Expression hiExpression = new LiteralExpression(aTextLocation().build(), new StringLiteral("Hi"));
		Expression thereExpression = new LiteralExpression(aTextLocation().build(), new StringLiteral(" there!"));
		BinaryExpression multiplyExpression = new BinaryExpression(aTextLocation().build(), hiExpression, thereExpression,
				new AddOperator("+"));

		Value result = multiplyExpression.accept(evaluator);

		assertThat(result, is(instanceOf(StringValue.class)));
		assertThat(((StringValue) result).getValue(), is("Hi there!"));
	}

}
