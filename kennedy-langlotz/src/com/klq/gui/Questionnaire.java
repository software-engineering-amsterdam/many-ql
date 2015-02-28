package com.klq.gui;

import com.klq.logic.controller.Store;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 27.02.2015.
 */
public class Questionnaire extends VBox {
    private final Store store;
    private final List<QuestionPage> questionPages;

    public Questionnaire(Store store) {
        super();
        this.store = store;
        this.questionPages = new ArrayList<QuestionPage>();
        init();
    }

    private void init(){
        this.setAlignment(Pos.TOP_RIGHT);
        this.setSpacing(5);
        this.setPadding(new Insets(5));

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.progressProperty().bind(store.progressProperty());
        progressBar.prefWidthProperty().bind(this.widthProperty());
        this.getChildren().add(progressBar);

        Button btn = createNextButton();
        this.getChildren().add(btn);
    }

    public boolean addQuestionPage(QuestionPage page){
        this.getChildren().add(0, page);
        this.store.updateVisibilities();
        return questionPages.add(page);
    }

    private Button createNextButton(){
        Button btn = new Button("Finish");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (store.progressProperty().get() < 1)
                    return; //Not yet done)
                if (store.exportResults(System.getProperty("user.dir") + File.separator + "out"))
                    System.exit(0);
                else {
                    //TODO: Java alerts coming in March 2015
                    //Too lazy for now!
                    System.err.println("Could not export file to user.dir!");
                }
            }
        });
        return btn;
    }
}
