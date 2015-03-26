package nl.uva.bromance;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.uva.bromance.visualization.Visualizer;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Visualizer vis = new Visualizer();
        vis.render(primaryStage);
    }
}