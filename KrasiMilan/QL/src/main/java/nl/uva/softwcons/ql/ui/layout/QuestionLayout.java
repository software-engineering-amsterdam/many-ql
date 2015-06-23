package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class QuestionLayout implements Layout {
    private final VBox vbox;
    private final Identifier questionId;

    public QuestionLayout(final Identifier questionId, final String label, final Widget layout) {
        this.vbox = new VBox();
        this.questionId = questionId;

        vbox.getChildren().add(new Label(label));
        vbox.getChildren().add(layout.getWidget());
    }

    @Override
    public Node getNode() {
        return vbox;
    }

    @Override
    public void add(final Layout layout) {
        vbox.getChildren().add(layout.getNode());
    }

    public Identifier getQuestionId() {
        return questionId;
    }

    public void setVisible(final boolean visible) {
        this.vbox.setVisible(visible);
        this.vbox.setManaged(visible);
    }

}
