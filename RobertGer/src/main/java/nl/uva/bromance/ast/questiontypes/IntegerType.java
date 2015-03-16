package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.visualization.Visualizer;

import java.util.List;
import java.util.Map;

/**
 * Created by Robert on 9-3-2015.
 */
public class IntegerType implements QuestionType {

    @Override
    public String getTypeString() {
        return "integer";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new IntResult(0);
    }

    @Override
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice, Map<String, String> answerMap, Visualizer visualizer, Question q) {
        TextField tf = new TextField();
        String answer = answerMap.get(q.getIdentifier().get().getId());
        if (answer != null) {
            tf.setText(answer);
        }
        // Disable any input other than numbers
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]*")) {
                tf.setText(oldValue);
            } else {
                answerMap.put(q.getIdentifier().get().getId(), newValue);
                visualizer.visualize();
            }
        });
        parent.getChildren().add(tf);
    }


}
