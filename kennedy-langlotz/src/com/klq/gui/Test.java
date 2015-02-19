package com.klq.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Timon on 17.02.2015.
 */
public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);

        QuestionPage pg = new QuestionPage(ExampleQuestions.all());
        root.getChildren().add(pg);
        primaryStage.show();
    }
}
