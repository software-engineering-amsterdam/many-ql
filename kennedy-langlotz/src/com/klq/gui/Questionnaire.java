package com.klq.gui;

import com.klq.logic.controller.Store;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 27.02.2015.
 */
public class Questionnaire extends GridPane {
    private final VBox content;
    private final Store store;
    private final List<QuestionPage> questionPages;

    public Questionnaire(Store store) {
        super();
        this.content = new VBox();
        this.store = store;
        this.questionPages = new ArrayList<QuestionPage>();
    }

    public boolean addQuestionPage(QuestionPage page){
        this.getChildren().add(page);
        store.updateVisibilities();
        return questionPages.add(page);
    }

    private Button createNextButton(){
        Button btn = new Button("Finish");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO notify parent
            }
        });
        return btn;
    }
}
