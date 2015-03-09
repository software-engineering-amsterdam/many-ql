package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;

public class ComputedQuestionLayout {

    private final ComputedQuestion question;
    private final VBox vbox;

    public ComputedQuestionLayout(final ComputedQuestion question) {
        this.question = question;
        vbox = new VBox();
        this.add(new Label(this.question.getLabel()));
    }

    public void add(Node node) {
        node.setDisable(true);
        vbox.getChildren().add(node);
    }

    public Node getNode() {
        return this.vbox;
    }

}
