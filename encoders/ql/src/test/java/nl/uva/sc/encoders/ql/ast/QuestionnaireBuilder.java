package nl.uva.sc.encoders.ql.ast;

import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;

import java.util.Arrays;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;

public class QuestionnaireBuilder {

	private TextLocation textLocation;
	private String name;
	private List<Statement> statements;

	public static QuestionnaireBuilder aQuestionnaire() {
		QuestionnaireBuilder questionnaireBuilder = new QuestionnaireBuilder();
		questionnaireBuilder.textLocation = aTextLocation().build();
		questionnaireBuilder.name = "TaxOfficeExample";
		questionnaireBuilder.statements = Arrays.asList((Statement) aQuestion().build());
		return questionnaireBuilder;
	}

	public Questionnaire build() {
		return new Questionnaire(textLocation, name, statements);
	}

	public QuestionnaireBuilder withQuestions(List<Question> questions) {
		statements.addAll(questions);
		return this;
	}
}
