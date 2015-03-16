package nl.uva.bromance.ast.questiontypes;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

import java.util.List;

/**
 * Created by Robert on 9-3-2015.
 */
public interface QuestionType {
    public String getTypeString();

    public Result getCorrespondingResultType();

    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice);

}