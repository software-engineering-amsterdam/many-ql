package nl.uva.bromance.ast.questiontypes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.Question;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.ast.visitors.QuestionTypeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

/**
 * Created by Robert on 9-3-2015.
 */
public class StringType implements QuestionType {

    private final Question q;
    private TextField textField;
    private Label label;

    public StringType(Question question) {
        this.q = question;
    }

    @Override
    public String getTypeString() {
        return "string";
    }

    @Override
    public void addQuestionToPane(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        label = new Label(q.getQuestionString());
        label.getStyleClass().add("prettyLabel");
        parent.getChildren().add(label);

        textField = new TextField();
        String id = q.getIdentifier();

        StringResult answer = (StringResult) answerMap.get(id);
        if (answer != null) {
            textField.setText(answer.getResult());
        }
        if (visualizer.getFocusUuid() == q.getUuid()) {
            visualizer.setFocusedNode(textField);
        }

        // Disable any input other than numbers
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            answerMap.put(id, new StringResult(newValue));
            visualizer.refresh(q.getUuid());
        });
        parent.getChildren().add(textField);

        setVisibilityOfComponents();
    }

    @Override
    public void refresh() {
        setVisibilityOfComponents();
    }

    @Override
    public void accept(QuestionTypeVisitor visitor) {
        visitor.visit(this);
    }

    private void setVisibilityOfComponents() {
        textField.setVisible(q.isVisible());
        label.setVisible(q.isVisible());
    }
}
