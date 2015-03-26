package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;
import java.util.Optional;

public class QLSSection extends QLSNode {
    private String identifier;

    public QLSSection(int lineNumber, String id) {
        super(lineNumber);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public Optional<? extends Pane> visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        Optional<? extends Pane> newParent = Optional.of(new VBox());
        javafx.scene.control.Label label = new javafx.scene.control.Label(this.identifier);
        label.getStyleClass().add("formHeader");
        newParent.get().getChildren().add(label);
        for (QLSNode child : this.getChildren()) {
            child.visualize(newParent.get(), answerMap, visualizer);
        }
        // Commented out for future usage when generating CSS
        //newParent.get().setStyle("-fx-border-color: #000000; -fx-border-style: solid;");
        newParent.get().getStyleClass().add("form");
        parent.getChildren().add(newParent.get());
        return newParent;
    }
}
