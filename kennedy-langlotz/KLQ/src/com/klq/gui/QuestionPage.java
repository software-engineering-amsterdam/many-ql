package com.klq.gui;

import com.klq.gui.pane.AQuestionPane;
import com.klq.gui.pane.DateQuestionPane;
import com.klq.gui.pane.BooleanQuestionPane;
import com.klq.gui.pane.TextQuestionPane;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
import com.kls.logic.StyleMap;
import com.kls.logic.style.AStyle;
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
    private final StyleMap style;

    public QuestionPage(Store store, StyleMap style){
        super();
        this.store = store;
        this.vbox = new VBox(10);
        this.style = style;
        init();
    }

    public QuestionPage(Store store){
        this(store, null);
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
        AQuestionPane questionPane;
        switch (question.getType()){
            case BOOLEAN:
                questionPane = new BooleanQuestionPane(question, store);
                break;
            case NUMERAL:
            case STRING:
                questionPane = new TextQuestionPane(question, store);
                break;
            case DATE:
                questionPane = new DateQuestionPane(question, store);
                break;
            default:
                throw new IllegalArgumentException("Unknown question type: " + question.getType());
        }
        //TODO let styling happen in AQuestionPane, need to do that for widgets anyway
        if(style != null && style.contains(question.getId().toString())){
            AStyle questionStyle = style.getStyle(question.getId().toString());
            questionPane.setStyle(questionStyle.toCSS());
        }

        return questionPane;
    }
}
