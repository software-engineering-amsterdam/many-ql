package nl.uva.softwcons.ql.ui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.softwcons.ql.Questionnaire;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.Statement;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.ui.layout.ComputedQuestionLayout;
import nl.uva.softwcons.ql.ui.layout.FormLayout;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class UiBuilder extends Application implements StatementVisitor<Node>, FormVisitor<Node> {

    private TypeRenderer renderer = new TypeRenderer();

    @Override
    public Node visit(Form form) {
        FormLayout layout = new FormLayout(form);
        for (Statement statement : form.getStatements()) {
            layout.add(statement.accept(this));
        }
        return layout.getNode();
    }

    @Override
    public Node visit(final ComputedQuestion question) {
        ComputedQuestionLayout layout = new ComputedQuestionLayout(question);
        Widget questionWidget = question.getType().accept(renderer);
        layout.add(questionWidget.getWidget());
        return layout.getNode();
    }

    @Override
    public Node visit(final Question question) {
        QuestionLayout layout = new QuestionLayout(question);
        Widget questionWidget = question.getType().accept(renderer);
        layout.add(questionWidget.getWidget());
        return layout.getNode();
    }

    @Override
    public Node visit(final Conditional conditional) {
        return null;
    }

    public static void main(String[] args) {
        launch(UiBuilder.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Form f = Questionnaire.build(UiBuilder.class.getResourceAsStream("/form.ql"));
        Node n = f.accept(new UiBuilder());

        StackPane root = new StackPane();
        root.getChildren().add(n);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}
