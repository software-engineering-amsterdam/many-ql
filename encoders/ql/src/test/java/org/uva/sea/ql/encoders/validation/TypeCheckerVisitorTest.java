package org.uva.sea.ql.encoders.validation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.type.StringType;

public class TypeCheckerVisitorTest {

	private TypeCheckerVisitor visitor;

	@Test
	public void testCheckTypes_findsDuplicateLabels() {
		String questionLabel = "What is the meaning of life?";
		Question questionA = new Question(new TextLocation(10, 10), "questionA", new StringType("string"), questionLabel);
		Question questionB = new Question(new TextLocation(12, 10), "questionB", new StringType("string"), questionLabel);
		List<Question> questions = Arrays.asList(questionA, questionB);
		visitor = new TypeCheckerVisitor(questions);

		List<Validation> validations = visitor.checkTypes();
		Validation validation = validations.get(0);
		assertThat(validation, is(notNullValue()));
		assertThat(validation.getValidationMessage(), is("Duplicate label: " + questionLabel));
	}
}
