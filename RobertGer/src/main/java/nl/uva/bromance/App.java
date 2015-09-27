package nl.uva.bromance;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.uva.bromance.QL.gui.QLGUI;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String stylesheets = this.getClass().getResource("style.css").toExternalForm();
        primaryStage.setResizable(false);
        QLGUI gui = new QLGUI(primaryStage,stylesheets);
        gui.render();
    }
}