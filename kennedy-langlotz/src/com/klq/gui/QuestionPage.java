package com.klq.gui;

import com.klq.logic.controller.Store;
import com.klq.logic.question.Id;
import com.klq.logic.question.Question;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.*;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPage extends ScrollPane implements IStoreListener {
    private Map<Question, QuestionPane> questionToQuestionPaneMap;
    private final VBox vbox;

    public QuestionPage(){
        super();
        questionToQuestionPaneMap = new HashMap<Question, QuestionPane>();
        vbox = new VBox(10);
        vbox.setPadding(new Insets(5));
        vbox.prefHeightProperty().bind(this.prefHeightProperty());
        vbox.setAlignment(Pos.TOP_RIGHT);
        this.setContent(vbox);
        this.setPrefWidth(400);
        this.setMinHeight(500);
        this.setFitToWidth(true);
        createFinishButton();
    }

    public void addQuestions(List<Question> questions){
        List<Id> updated = new ArrayList<Id>();
        for (Question question : questions) {
            QuestionPane newPane = new QuestionPane(question);
            vbox.getChildren().add(vbox.getChildren().size()-1, newPane);
            questionToQuestionPaneMap.put(question, newPane);
            updated.add(question.getId());
        }
        storeUpdated();
    }

    private void createFinishButton(){
        Button btn = new Button("Finish");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(exportResults());
            }
        });
        vbox.getChildren().add(vbox.getChildren().size(), btn);
    }

    private int exportResults(){
        //TODO export
        return -1;
    }

    @Override
    public void storeUpdated() {
        for (Question question : questionToQuestionPaneMap.keySet()) {

            if (question.dependenciesResolved())
                questionToQuestionPaneMap.get(question).show();
            else
                questionToQuestionPaneMap.get(question).hide();

        }
    }
}
