package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.visualization.Visualizer;

import java.util.List;
import java.util.Map;

/**
 * Created by Robert on 9-3-2015.
 */
public class BooleanType implements QuestionType {
    @Override
    public String getTypeString() {
        return "boolean";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new BooleanResult(false);
    }

    @Override
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice, Map<String, Result> answerMap, Visualizer visualizer, Question q) {

        CheckBox cb = new CheckBox();
        String id = q.getIdentifier().getId();

        BooleanResult answer = (BooleanResult) answerMap.get(id);
        if (answer != null) {
            if (answer.getResult() == true) {
                cb.setSelected(true);
            }
        }
        if (visualizer.getFocusId() == q.hashCode()){
            visualizer.setFocusedNode(cb);
        }

        cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true){
                answerMap.put(id,new BooleanResult(true));
            } else {
                answerMap.put(id,new BooleanResult(false));
            }
            visualizer.visualize(q.hashCode());
        });
        parent.getChildren().add(cb);
    }

}
