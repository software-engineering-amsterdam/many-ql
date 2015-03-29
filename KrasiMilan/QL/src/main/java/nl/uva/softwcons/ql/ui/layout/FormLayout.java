package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class FormLayout implements Layout {
    private final VBox vbox;

    public FormLayout() {
        this.vbox = new VBox();
    }

    @Override
    public void add(final Layout node) {
        this.vbox.getChildren().add(node.getNode());
    }

    @Override
    public Node getNode() {
        return this.vbox;
    }

}
