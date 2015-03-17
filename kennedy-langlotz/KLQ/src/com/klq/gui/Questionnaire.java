package com.klq.gui;

import com.klq.controller.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 27.02.2015.
 */
public class Questionnaire extends AnchorPane {
    private final List<QuestionPage> questionPages;
    private final Controller controller;
    private final ScrollPane currentPagePane;
    private final Button nextButton;
    private final Button backButton;
    private int currentPageIndex = 0;

    private final StringProperty statusProperty;
    private final Label statusLabel;

    public Questionnaire(Controller controller) {
        super();
        this.controller = controller;
        this.questionPages = new ArrayList<>();
        this.backButton = createBackButton();
        this.nextButton = createNextButton();
        this.currentPagePane = new ScrollPane();
        this.statusProperty = new SimpleStringProperty();
        this.statusLabel = new Label();
        init();
    }

    private void init(){
        this.currentPagePane.setFitToWidth(true);
        this.setPadding(new Insets(5));

        ProgressBar progressBar = createProgressBar();

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setSpacing(5);
        hbox.getChildren().add(statusLabel);
        hbox.getChildren().add(backButton);
        hbox.getChildren().add(nextButton);

        VBox bottom = new VBox(5);
        bottom.getChildren().add(progressBar);
        bottom.getChildren().add(hbox);
        this.getChildren().add(bottom);

        setLeftAnchor(bottom, 2d);
        setBottomAnchor(bottom, 2d);
        setRightAnchor(bottom, 2d);

        setTopAnchor(currentPagePane, 5d);
        setLeftAnchor(currentPagePane, 5d);
        setRightAnchor(currentPagePane, 5d);
        setBottomAnchor(currentPagePane, 60d);

        statusLabel.setTextFill(Paint.valueOf("red"));
        statusLabel.textProperty().bind(statusProperty);
    }

    public void addQuestionPage(QuestionPage page){
        this.controller.updateQuestionVisibilities();
        this.questionPages.add(page);
        if (this.currentPagePane.getContent() == null) {
            this.currentPagePane.setContent(page);
            this.getChildren().add(0, currentPagePane);
        } else
            nextButton.setText("Next");
    }

    private ProgressBar createProgressBar(){
        ProgressBar progressBar = new ProgressBar(0);
        progressBar.progressProperty().bind(controller.progressProperty());
        progressBar.prefWidthProperty().bind(this.widthProperty());
        progressBar.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.equals(1.0))
                    progressBar.setStyle("-fx-accent: #06ff40;");
                else
                    progressBar.setStyle("-fx-accent: #0b9add;");
            }
        });
        return progressBar;
    }

    private Button createBackButton(){
        Button btn = new Button("Back");
        btn.setDisable(true);
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPageIndex > 0) {
                    showPreviousQuestionPage();
                    if (currentPageIndex == 0)
                        btn.setDisable(true);
                }
            }
        });
        return btn;
    }

    private Button createNextButton(){
        Button btn = new Button("Finish");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (currentPageIndex < questionPages.size()-1) {
                    showNextQuestionPage();
                    if (currentPageIndex == questionPages.size()-1)
                        nextButton.setText("Finish");
                    if (currentPageIndex == 0)
                        backButton.setDisable(false);
                    return;
                }
                if (controller.progressProperty().get() < 1) {
                    statusProperty.set("You need to complete all questions!");
                    return;
                }
                exportResults();
            }
        });
        return btn;
    }

    private void showPreviousQuestionPage(){
        this.currentPagePane.setContent(questionPages.get(--currentPageIndex));
    }

    private void showNextQuestionPage(){
        this.currentPagePane.setContent(questionPages.get(++currentPageIndex));
    }

    private void exportResults(){
        if (controller.exportResults(System.getProperty("user.dir") + File.separator + "out"))
            System.exit(0);
        else {
            statusProperty.set("Could not export file to user.dir!");
        }
    }
}
