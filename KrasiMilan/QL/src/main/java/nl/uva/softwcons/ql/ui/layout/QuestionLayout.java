package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class QuestionLayout {
    private final VBox vbox;

    public QuestionLayout(final String label, final Widget layout) {
        this.vbox = new VBox();

        vbox.getChildren().add(new Label(label));
        vbox.getChildren().add(layout.getWidget());
    }

    public Node getNode() {
        return this.vbox;
    }

    public void setVisible(final boolean visible) {
        this.vbox.setVisible(visible);
        this.vbox.setManaged(visible);
    }

}
