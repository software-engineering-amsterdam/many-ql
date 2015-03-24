package nl.uva.sc.encoders.ql.ast;

import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;

public class QuestionnaireBuilder {

	private TextLocation textLocation;
	private String name;
	private List<Statement> statements = new ArrayList<>();

	public static QuestionnaireBuilder aQuestionnaire() {
		QuestionnaireBuilder questionnaireBuilder = new QuestionnaireBuilder();
		questionnaireBuilder.textLocation = aTextLocation().build();
		questionnaireBuilder.name = "TaxOfficeExample";
		questionnaireBuilder.statements.add(aQuestion().build());
		return questionnaireBuilder;
	}

	public Questionnaire build() {
		return new Questionnaire(textLocation, name, statements);
	}

	public QuestionnaireBuilder withQuestions(List<Question> questions) {
		statements.clear();
		statements.addAll(questions);
		return this;
	}

	public QuestionnaireBuilder withConditionalBlocks(List<ConditionalBlock> conditionalBlocks) {
		statements.clear();
		statements.addAll(conditionalBlocks);
		return this;
	}

	public QuestionnaireBuilder withStatements(List<Statement> statements) {
		this.statements = statements;
		return this;
	}
}
