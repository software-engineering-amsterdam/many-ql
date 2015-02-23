package nl.uva.bromance.AST.Conditionals;

import javafx.scene.layout.Pane;
import nl.uva.bromance.AST.Node;

import java.util.Optional;

/**
 * Created by Robert on 23-2-2015.
 */
public class ExpressionEvaluator {

    public static void evaluateNode(Node node) {

        if(node instanceof Expression) {
            ((Expression) node).evaluate();
        }
        if (node.hasChildren()) {
            for (Node child : node.getChildren()) {
                    evaluateNode(child);

            }
        }
    }
}
