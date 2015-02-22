package nl.uva.bromance.visualization;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.uva.bromance.AST.Node;
import nl.uva.bromance.AST.Questionnaire;

import java.util.Optional;

public class Visualizer {

    public void visualize(Questionnaire ast, Stage stage) {
        Optional<? extends Pane> root = Optional.of(new VBox());
        Scene scene = new Scene(root.get());

        if (ast.hasChildren()) {
            visualChildren(ast, root);
        }

        stage.setScene(scene);
        stage.show();
    }

    private void visualChildren(Node node, Optional<? extends Pane> parent) {
        for (Node child : node.getChildren()) {
            if (child.hasChildren()) {
                Optional<? extends Pane> newParent = child.visualize(parent.get());
                if (newParent.isPresent()) {
                    visualChildren(child, newParent);
                } else {
                    visualChildren(child, parent);
                }
            } else {
                child.visualize(parent.get());
            }
        }
    }
}

