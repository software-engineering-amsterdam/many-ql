package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QLSNodeElement;
import nl.uva.bromance.visualization.Visualizable;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

public abstract class QLSNode extends Node<QLSNode> implements Visualizable, QLSNodeElement {
    public QLSNode(int ln) {
        super(ln);
    }

    @Override
    public void setVisible(boolean visible) {

    }
}
