package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.visualization.Visualizable;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Robert on 16-3-2015.
 */
public class QLSNode extends Node<QLSNode> implements Visualizable {
    public QLSNode(int ln) {
        super(ln);
    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        return null;
    }

    @Override
    public void isVisible(boolean visible) {

    }
}
