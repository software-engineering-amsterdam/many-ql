package nl.uva.softwcons.ui.layout;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ast.statement.Question;

public class QuestionLayout {

    private final Question question;
    private final VBox vbox;

    public QuestionLayout(final Question question) {
        this.question = question;
        vbox = new VBox();
        this.add(new Label(this.question.getLabel()));
    }

    public void add(Node node) {
        // node.setOnMouseReleased(value);
        vbox.getChildren().add(node);
    }

    public Node getNode() {
        return this.vbox;
    }

}
