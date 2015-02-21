package nl.uva.bromance.visualization;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.uva.bromance.AST.Node;
import nl.uva.bromance.AST.Root;

public class Visualizer {

    public void visualize(Root ast, Stage stage) {
        VBox root = new VBox();
        Scene scene = new Scene(root);

        if (ast.hasChildren()) {
            visualChildren(ast, root);
        }

        stage.setScene(scene);
        stage.show();
    }

    private void visualChildren(Node node, Pane parent) {
        for (Node child : node.getChildren()) {
            if (child.hasChildren()) {
                Pane newParent = child.visualize(parent);
                if (newParent != null) {
                    visualChildren(child, newParent);
                } else {
                    visualChildren(child, parent);
                }
            } else {
                child.visualize(parent);
            }
        }
    }
}

