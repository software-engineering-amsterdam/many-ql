package com.klq.gui;

import com.klq.gui.pane.AQuestionPane;
import com.klq.gui.pane.DateQuestionPane;
import com.klq.gui.pane.SetQuestionPane;
import com.klq.gui.pane.TextQuestionPane;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
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
    private final Store store;
    private final VBox vbox;

    public QuestionPage(Store store){
        super();
        this.store = store;
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

    public void addQuestions(List<Question> questions){
        for (Question question : questions) {
            AQuestionPane newPane = createQuestionPane(question);
            vbox.getChildren().add(newPane);
        }
    }

    private AQuestionPane createQuestionPane(Question question){
        switch (question.getType()){
            case SET:
            case BOOLEAN:
                return new SetQuestionPane(question, store);
            case NUMERAL:
            case STRING:
                return new TextQuestionPane(question, store);
            case DATE:
                return new DateQuestionPane(question, store);
        }
        throw new IllegalArgumentException("Unknown question type: " + question.getType());
    }
}
