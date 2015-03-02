package nl.uva.softwcons.ui.layout;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ast.form.Form;

public class FormLayout {

    private final Form form;
    private final VBox vbox;

    public FormLayout(final Form form) {
        this.form = form;
        this.vbox = new VBox();
    }

    public void add(Node node) {
        this.vbox.getChildren().add(node);
    }

    public Node getNode() {
        return this.vbox;
    }

}
