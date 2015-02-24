package com.klq.gui;

import com.klq.logic.controller.Store;
import com.klq.logic.question.Id;
import com.klq.logic.question.Question;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
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
        vbox.setStyle("-fx-background-color: #FFFFFF;");
        this.setContent(vbox);
        this.setFitToWidth(true);
    }

    public void addQuestions(List<Question> questions){
        List<Id> updated = new ArrayList<Id>();
        for (Question question : questions) {
            QuestionPane newPane = new QuestionPane(question);
            vbox.getChildren().add(newPane);
            questionToQuestionPaneMap.put(question, newPane);
            updated.add(question.getId());
        }
        storeUpdated(updated);
    }


    @Override
    public void storeUpdated(List<Id> changed) {
        for (Question question : questionToQuestionPaneMap.keySet()) {
            for (Id id : changed) {
                if (question.getId().equals(id)){
                    if (question.dependenciesResolved())
                        questionToQuestionPaneMap.get(question).show();
                    else
                        questionToQuestionPaneMap.get(question).hide();
                }
            }
        }
    }
}
