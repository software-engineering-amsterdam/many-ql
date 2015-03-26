package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.CustomResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.visualization.Visualizer;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Robert on 9-3-2015.
 */
public class CustomType implements QuestionType {
    private List<StringResult> multipleChoiceOptions = new ArrayList<>();

    public CustomType(List<TerminalNode> options) {
        for (TerminalNode option : options) {
            String customOption = option.getText();
            customOption = customOption.substring(1, customOption.length() - 1); // Remove double quotes around the question.
            multipleChoiceOptions.add(new StringResult(customOption));
        }
    }

    @Override
    public String getTypeString() {
        return "custom";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new CustomResult(Arrays.asList(new StringResult("")));
    }

    @Override
    public void addQuestionToPane(Pane parent, List<StringResult> multipleChoice, Map<String, Result> answerMap, Visualizer visualizer, Question q) {
        ToggleGroup group = new ToggleGroup();
        String id = q.getIdentifier();
        StringResult answer = (StringResult) answerMap.get(id);

        group.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            RadioButton rb = (RadioButton) newToggle.getToggleGroup().getSelectedToggle();
            answerMap.put(id, new StringResult(rb.getText()));
            if ((oldToggle != null && !oldToggle.equals(newToggle)) || (answer == null && oldToggle == null)) {
                visualizer.visualize(q.hashCode());
            }
        });

        for (StringResult option : multipleChoice) {
            RadioButton radioButton = new RadioButton(option.getResult());
            radioButton.setToggleGroup(group);
            if (answer != null && option.getResult().equals(answer.getResult())) {
                radioButton.setSelected(true);
                if (visualizer.getFocusId() == q.hashCode()) {
                    visualizer.setFocusedNode(radioButton);
                }
            }
            parent.getChildren().add(radioButton);
        }
    }
}
