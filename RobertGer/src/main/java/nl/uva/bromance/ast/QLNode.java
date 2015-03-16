package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.visitors.NodeElement;
import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckable;
import nl.uva.bromance.typechecking.TypeCheckingException;
import nl.uva.bromance.visualization.Visualizable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class QLNode extends Node<QLNode> implements NodeElement, Visualizable {


    public QLNode(int ln, Class<? extends Node> type) {
        super(ln, type);
    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent) {

        return Optional.empty();
    }

    @Override
    public void isVisible(boolean visible) {
        
    }
}
