package nl.uva.sc.encoders.qlruntime.ui.handler;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.ui.QuestionnaireGridPane;

public class ShowButtonHandler implements EventHandler<ActionEvent> {

	public interface RuntimeQuestionsCallback {
		List<RuntimeQuestion> getRuntimeQuestions();
	}

	public interface ShowResultCallback {
		void showResult(QuestionnaireGridPane result);
	}

	private RuntimeQuestionsCallback runtimeQuestionsCallback;

	private ShowResultCallback showResultCallback;

	public ShowButtonHandler(RuntimeQuestionsCallback runtimeQuestionsCallback, ShowResultCallback showResultCallback) {
		this.runtimeQuestionsCallback = runtimeQuestionsCallback;
		this.showResultCallback = showResultCallback;
	}

	@Override
	public void handle(ActionEvent event) {
		List<RuntimeQuestion> runtimeQuestions = runtimeQuestionsCallback.getRuntimeQuestions();
		QuestionnaireGridPane questionnaireGridPane = new QuestionnaireGridPane();
		questionnaireGridPane.showQuestions(runtimeQuestions);
		showResultCallback.showResult(questionnaireGridPane);
	}
}
