package nl.uva.bromance;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            new Runner().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}