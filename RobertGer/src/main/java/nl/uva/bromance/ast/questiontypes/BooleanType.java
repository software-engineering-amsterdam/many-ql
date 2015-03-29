package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QuestionTypeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

public class BooleanType implements QuestionType {

    private final Question q;
    private CheckBox checkBox;
    private Label label;

    public BooleanType(Question question) {
        this.q = question;
    }

    @Override
    public String getTypeString() {
        return "boolean";
    }

    @Override
    public void addQuestionToPane(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        if (q.isVisible()) {
            label = new Label(q.getQuestionString());
            label.getStyleClass().add("prettyLabel");
            parent.getChildren().add(label);

            checkBox = new CheckBox();
            String id = q.getIdentifier();

            BooleanResult answer = (BooleanResult) answerMap.get(id);
            if (answer != null) {
                if (answer.getResult() == true) {
                    checkBox.setSelected(true);
                }
            }
            if (visualizer.getFocusUuid() == q.getUuid()) {
                visualizer.setFocusedNode(checkBox);
            }

            checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == true) {
                    answerMap.put(id, new BooleanResult(true));
                } else {
                    answerMap.put(id, new BooleanResult(false));
                }
                visualizer.refresh(q.getUuid());
            });
            parent.getChildren().add(checkBox);
        }
    }

    @Override
    public void accept(QuestionTypeVisitor visitor) {
        visitor.visit(this);
    }

}
