package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QlsNodeElement;
import nl.uva.bromance.visualization.Visualizable;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

/**
 * Created by Robert on 16-3-2015.
 */
public abstract class QLSNode extends Node<QLSNode> implements Visualizable, QlsNodeElement {
    public QLSNode(int ln) {
        super(ln);
    }

    @Override
    public void visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
    }

    @Override
    public void isVisible(boolean visible) {

    }
}
