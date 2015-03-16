package nl.uva.sc.encoders.qlruntime.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.qlruntime.runtime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.runtime.model.RuntimeQuestionnaire;
import nl.uva.sc.encoders.qlruntime.runtime.value.Value;

public class AstTransformer {

	public RuntimeQuestionnaire transform(Questionnaire questionnaire) {
		List<Question> questions = questionnaire.getAllQuestions();

		List<RuntimeQuestion> uiQuestions = createUIQuestions(questions);
		String name = questionnaire.getName();
		RuntimeQuestionnaire uiQuestionnaire = new RuntimeQuestionnaire(uiQuestions, name);

		return uiQuestionnaire;
	}

	private List<RuntimeQuestion> createUIQuestions(Collection<Question> questions) {
		List<RuntimeQuestion> uiQuestions = new ArrayList<RuntimeQuestion>();
		for (Question question : questions) {
			DataType dataType = question.getDataType();
			Value defaultValue = dataType.accept(new DefaultValueVisitor());
			uiQuestions.add(new RuntimeQuestion(question, defaultValue));
		}
		return uiQuestions;
	}

	public List<Question> transform(Collection<RuntimeQuestion> runtimeQuestions) {
		List<Question> questions = new ArrayList<>();
		for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			questions.add(runtimeQuestion.getQuestion());
		}
		return questions;
	}
}
