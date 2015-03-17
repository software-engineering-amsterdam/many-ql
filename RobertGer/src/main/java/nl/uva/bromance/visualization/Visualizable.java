package nl.uva.bromance.visualization;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Robert on 2/19/2015.
 */
public interface Visualizable {

    Optional<? extends Pane> visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer);

    void isVisible(boolean visible);
}
