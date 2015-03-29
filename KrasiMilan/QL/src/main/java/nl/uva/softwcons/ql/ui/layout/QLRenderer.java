package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class QLRenderer implements Renderer {
    private final VBox vbox;

    public QLRenderer() {
        this.vbox = new VBox();
    }

    @Override
    public void add(final QuestionLayout node) {
        this.vbox.getChildren().add(node.getNode());
    }

    @Override
    public Node getNode() {
        return this.vbox;
    }

}
