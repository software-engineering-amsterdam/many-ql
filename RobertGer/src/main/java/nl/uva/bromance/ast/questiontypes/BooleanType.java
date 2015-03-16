package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

import java.util.List;

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
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice) {
        parent.getChildren().add(new CheckBox());
    }

}
