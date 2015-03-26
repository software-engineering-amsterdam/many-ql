package nl.uva.bromance.visualization;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;

import java.util.Map;

/**
 * Created by Robert on 2/19/2015.
 */
public interface Visualizable {

    void visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer);

    void isVisible(boolean visible);
}
