package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QLSNodeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

public class QLSPage extends QLSNode {
    private String identifier;
    private javafx.scene.control.Label label;

    public QLSPage(int lineNumber, String id) {
        super(lineNumber);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void addPageToPane(Pane parent, Visualizer visualizer) {
        if (visualizer.getCurrentPage() == null) {
            visualizer.setCurrentPage(this);
        }

        String identifier = getIdentifier();
        label = new javafx.scene.control.Label(identifier);
        label.setOnMouseClicked((event) -> {
            visualizer.setCurrentPage(this);
            visualizer.refresh();
        });
        if (visualizer.getCurrentPage() == this) {
            label.getStyleClass().add("active");
            visitChildren(visualizer);
        } else {
            label.getStyleClass().remove("active");
        }
        label.getStyleClass().add("pageLabel");
        parent.getChildren().add(label);
    }

    public void refresh(Visualizer visualizer){
        if (visualizer.getCurrentPage() == this){
            label.getStyleClass().remove("active");
            label.getStyleClass().add("active");
        } else {
            label.getStyleClass().remove("active");
        }
    }

    @Override
    public void accept(QLSNodeVisitor visitor) {
        visitor.visit(this);
    }

    public void visitChildren(QLSNodeVisitor visitor) {
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
