package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

/**
 * Created by Robert on 9-3-2015.
 */
public class IntegerType implements QuestionType {


    private final Question q;
    private TextField textField;
    private Label label;

    public IntegerType(Question question) {
        this.q = question;
    }

    @Override
    public String getTypeString() {
        return "integer";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new IntResult(0);
    }

    @Override
    public void addQuestionToPane(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        label = new Label(q.getQuestionString());
        label.getStyleClass().add("prettyLabel");
        parent.getChildren().add(label);

        textField = new TextField();
        String id = q.getIdentifier().getId();
        IntResult answer = (IntResult) answerMap.get(id);
        if (answer != null) {
            textField.setText(Integer.toString(answer.getResult()));
        }
        if (visualizer.getFocusUuid() == q.getUuid()) {
            visualizer.setFocusedNode(textField);
        }

        // Disable any input other than numbers
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9-]*")) {
                textField.setText(oldValue);
            } else {
                if (newValue.length() >= 1 && !newValue.equals("-")){
                    answerMap.put(id, new IntResult(Integer.parseInt(newValue)));
                }
                if (newValue.length() == 0){
                    answerMap.put(id, new IntResult(0));
                }
                visualizer.visualize(q.getUuid());
            }
        });
        parent.getChildren().add(textField);

        setVisibilityOfComponents();
    }

    @Override
    public void refresh() {
        setVisibilityOfComponents();
    }

    private void setVisibilityOfComponents() {
        textField.setVisible(q.isVisible());
        label.setVisible(q.isVisible());
    }


}
