package nl.uva.bromance.visualization;

import javafx.scene.layout.Pane;

import java.util.Optional;

/**
 * Created by Robert on 2/19/2015.
 */
public interface Visualizable {

    Optional<? extends Pane> visualize(Pane parent);
}
