package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ql.ast.statement.Question;

public class QuestionLayout {

    private final Question question;
    private final VBox vbox;

    public QuestionLayout(final Question question) {
        this.question = question;
        this.vbox = new VBox();

        this.add(new Label(this.question.getLabel()));
    }

    public void add(Node node) {
        vbox.getChildren().add(node);
    }

    public Node getNode() {
        return this.vbox;
    }

    public void setVisible(final boolean visible) {
        this.vbox.setVisible(visible);
        this.vbox.setManaged(visible);
    }

}
