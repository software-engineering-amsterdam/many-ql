package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

import java.util.List;

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
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice) {
        TextField tf = new TextField();
        // Disable any input other than numbers
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]*")) {
                tf.setText(oldValue);
            }
        });
        parent.getChildren().add(tf);
    }


}
