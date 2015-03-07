package nl.uva.bromance.visualization;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.uva.bromance.AST.Node;
import nl.uva.bromance.AST.Questionnaire;

import java.util.Optional;

public class Visualizer {

    public void visualize(Node ast, Stage stage) {
        VBox rootBox = new VBox();
        rootBox.getStyleClass().add("questionnaire");
        Optional<? extends Pane> root = Optional.of(rootBox);
        Scene scene = new Scene(root.get());
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

        if (ast.hasChildren()) {
            visualChildren(ast, root);
        }

        stage.setScene(scene);
        stage.show();
    }

    private void visualChildren(Node node, Optional<? extends Pane> parentPane) {
        for (Node child : node.getChildren()) {
            if (child.hasChildren()) {
                Optional<? extends Pane> newParent = child.visualize(parentPane.get());
                if (newParent.isPresent()) {
                    visualChildren(child, newParent);
                } else {
                    visualChildren(child, parentPane);
                }
            } else {
                child.visualize(parentPane.get());
            }
        }
    }
}

