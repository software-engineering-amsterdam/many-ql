package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

import java.util.List;

/**
 * Created by Robert on 9-3-2015.
 */
public class StringType implements QuestionType {

    @Override
    public String getTypeString() {
        return "string";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new StringResult("");
    }

    @Override
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice) {
        parent.getChildren().add(new TextField());
    }
}
