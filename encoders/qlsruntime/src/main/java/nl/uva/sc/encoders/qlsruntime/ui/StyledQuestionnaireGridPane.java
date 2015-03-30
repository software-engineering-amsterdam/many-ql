package nl.uva.sc.encoders.qlsruntime.ui;

import java.util.List;

import javafx.scene.control.Control;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.ui.QuestionnaireGridPane;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlGenerator;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlPropertyChangeWrapper;
import nl.uva.sc.encoders.qls.ast.DefaultStyle;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.property.DefaultStyleProperty;

public class StyledQuestionnaireGridPane extends QuestionnaireGridPane {

	private final Page page;

	public StyledQuestionnaireGridPane(List<RuntimeQuestion> allRuntimeQuestions, List<RuntimeQuestion> runtimeQuestionsToShow,
			Page page) {
		super(allRuntimeQuestions, runtimeQuestionsToShow);
		this.page = page;
	}

	@Override
	protected ControlPropertyChangeWrapper generateControl(RuntimeQuestion runtimeQuestion) {
		Question question = runtimeQuestion.getQuestion();
		DataType dataType = question.getDataType();
		ControlGenerator controlGenerator = new ControlGenerator(runtimeQuestion);
		ControlPropertyChangeWrapper controlPropertyChangeWrapper = dataType.accept(controlGenerator);
		Control control = controlPropertyChangeWrapper.getControl();

		DefaultStyle defaultStyle = page.getDefaultStyle(question.getName());
		if (defaultStyle != null) {
			List<DefaultStyleProperty> defaultStyleProperties = defaultStyle.getDefaultStyleProperties();
			String style = "";
			for (DefaultStyleProperty defaultStyleProperty : defaultStyleProperties) {
				style += defaultStyleProperty.accept(new StyleGenerator());
				control.setStyle(style);
			}
		}
		return controlPropertyChangeWrapper;
	}
}
