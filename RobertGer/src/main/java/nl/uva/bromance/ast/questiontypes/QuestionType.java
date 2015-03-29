package nl.uva.bromance.ast.questiontypes;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

/**
 * Created by Robert on 9-3-2015.
 */
public interface QuestionType {

    public String getTypeString();

    public Result getCorrespondingResultType();

    public void addQuestionToPane(Pane parent, Map<String, Result> answerMap, Visualizer visualizer);

    public void refresh();
}