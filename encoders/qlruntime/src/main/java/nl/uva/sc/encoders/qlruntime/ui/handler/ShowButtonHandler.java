package nl.uva.sc.encoders.qlruntime.ui.handler;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.ui.QuestionnaireGridPane;

public class ShowButtonHandler implements EventHandler<ActionEvent> {

	public interface QuestionnaireCallback {
		Questionnaire getQuestionnaire();
	}

	public interface ShowResultCallback {
		void showResult(QuestionnaireGridPane result);
	}

	private QuestionnaireCallback questionnaireCallback;

	private ShowResultCallback showResultCallback;

	public ShowButtonHandler(QuestionnaireCallback questionnaireCallback, ShowResultCallback showResultCallback) {
		this.questionnaireCallback = questionnaireCallback;
		this.showResultCallback = showResultCallback;
	}

	@Override
	public void handle(ActionEvent event) {
		QuestionnaireToRuntimeQuestions questionnaireToRuntimeQuestions = new QuestionnaireToRuntimeQuestions();
		Questionnaire questionnaire = questionnaireCallback.getQuestionnaire();
		List<RuntimeQuestion> runtimeQuestions = questionnaireToRuntimeQuestions.createRuntimeQuestions(questionnaire);
		QuestionnaireGridPane questionnaireGridPane = new QuestionnaireGridPane(runtimeQuestions);
		showResultCallback.showResult(questionnaireGridPane);
	}
}
