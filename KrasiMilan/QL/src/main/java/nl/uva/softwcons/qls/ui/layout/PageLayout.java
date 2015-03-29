package nl.uva.softwcons.qls.ui.layout;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import nl.uva.softwcons.ql.ui.layout.Layout;

public class PageLayout implements Layout {
    private final VBox layout;

    public PageLayout() {
        this.layout = new VBox();
        this.layout.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
    }

    @Override
    public void add(final Layout layout) {
        this.layout.getChildren().add(layout.getNode());
    }

    @Override
    public Node getNode() {
        return layout;
    }
}
