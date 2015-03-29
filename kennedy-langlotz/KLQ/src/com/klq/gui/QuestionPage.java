package com.klq.gui;

import com.klq.gui.control.ARenderedQuestion;
import com.klq.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPage extends ScrollPane {
    private final Controller controller;
    private final VBox vbox;

    public QuestionPage(Controller controller){
        super();
        this.controller = controller;
        this.vbox = new VBox(10);
        init();
    }

    private void init(){
        this.vbox.setPadding(new Insets(5));
        this.vbox.prefHeightProperty().bind(this.prefHeightProperty());
        this.vbox.setAlignment(Pos.TOP_RIGHT);
        this.setContent(vbox);
        this.setPrefWidth(400);
        this.setFitToWidth(true);
        this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        this.setBorder(Border.EMPTY);
    }

    public void addQuestions(List<ARenderedQuestion> questions){
        for (ARenderedQuestion question : questions) {
            vbox.getChildren().add(question.getControl());
        }
    }
}
