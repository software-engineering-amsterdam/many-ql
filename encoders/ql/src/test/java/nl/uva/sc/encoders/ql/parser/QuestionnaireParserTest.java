package nl.uva.sc.encoders.ql.parser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.operator.BinaryOperator;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;
import nl.uva.sc.encoders.ql.validation.SyntaxError;

import org.junit.Before;
import org.junit.Test;

public class QuestionnaireParserTest {

	private static final String RESOURCE_ROOT = "src/main/resources/";
	private QuestionnaireParser parser;

	@Before
	public void setUp() {
		parser = new QuestionnaireParser();
	}

	@Test
	public void testParse_validInputGivesResultWithAbstractSyntaxTree() throws Exception {
		QuestionnaireParsingResult result = parser.parse(RESOURCE_ROOT + "ql/input_form.ql");

		assertThat(result, is(notNullValue()));
		List<SyntaxError> syntaxErrors = result.getSyntaxErrors();
		assertThat(syntaxErrors.toString(), syntaxErrors.size(), is(0));
		Questionnaire questionnaire = result.getQuestionnaire();
		assertThat(questionnaire, is(notNullValue()));
		assertThat(questionnaire.getName(), is("taxOfficeExample"));
		List<Statement> statements = questionnaire.getStatements();
		assertThat(statements, is(notNullValue()));
		assertThat(statements.toString(), statements.size(), is(9));
		Question hasSoldHouse = (Question) statements.get(0);
		assertThat(hasSoldHouse.getName(), is("hasSoldHouse"));
		ConditionalBlock conditionalBlock = (ConditionalBlock) statements.get(7);
		BinaryExpression condition = (BinaryExpression) conditionalBlock.getCondition();
		BinaryOperator operator = condition.getOperator();
		assertThat(operator.toString(), is("&&"));

	}

	@Test
	public void testParse_inputWithSyntaxErrorsGivesResultWithSyntaxErrors() throws Exception {
		QuestionnaireParsingResult result = parser.parse(RESOURCE_ROOT + "ql/input_form_with_syntax_errors.ql");

		assertThat(result, is(notNullValue()));
		List<SyntaxError> syntaxErrors = result.getSyntaxErrors();
		assertThat(syntaxErrors.toString(), syntaxErrors.size(), is(5));
		SyntaxError missingFormError = syntaxErrors.get(0);
		assertThat(missingFormError.getValidationMessage(), is("missing 'form' at 'fom'"));
		TextLocation textLocation = missingFormError.getTextLocation();
		assertThat(textLocation.getColumn(), is(0));
		assertThat(textLocation.getLine(), is(1));
	}
}
