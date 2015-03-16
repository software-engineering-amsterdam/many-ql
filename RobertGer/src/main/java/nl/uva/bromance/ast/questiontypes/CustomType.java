package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.CustomResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Robert on 9-3-2015.
 */
public class CustomType implements QuestionType {

    @Override
    public String getTypeString() {
        return "custom";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new CustomResult(Arrays.asList(new StringResult("")));
    }

    @Override
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice) {
        ToggleGroup group = new ToggleGroup();
        for (StringResult option : multipleChoice) {
            RadioButton radioButton = new RadioButton(option.getResult());
            radioButton.setToggleGroup(group);
            parent.getChildren().add(radioButton);
        }
    }
}
