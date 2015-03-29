package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QlNodeElement;
import nl.uva.bromance.visualization.Visualizable;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

public abstract class QLNode extends Node<QLNode> implements QlNodeElement, Visualizable {


    public QLNode(int ln) {
        super(ln);
    }

    @Override
    public void setVisible(boolean visible) {

    }
}
