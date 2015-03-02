package nl.uva.softwcons.ui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.softwcons.Questionnaire;
import nl.uva.softwcons.ast.form.Form;
import nl.uva.softwcons.ast.form.FormVisitor;
import nl.uva.softwcons.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ast.statement.Conditional;
import nl.uva.softwcons.ast.statement.Question;
import nl.uva.softwcons.ast.statement.Statement;
import nl.uva.softwcons.ast.statement.StatementVisitor;
import nl.uva.softwcons.ui.layout.ComputedQuestionLayout;
import nl.uva.softwcons.ui.layout.FormLayout;
import nl.uva.softwcons.ui.layout.QuestionLayout;
import nl.uva.softwcons.ui.widget.Widget;

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
    public Node visit(ComputedQuestion statement) {
        ComputedQuestionLayout layout = new ComputedQuestionLayout(statement);
        layout.add(statement.getType().accept(renderer).getWidget());
        return layout.getNode();
    }

    @Override
    public Node visit(Question statement) {
        QuestionLayout layout = new QuestionLayout(statement);
        Widget questionWidget = statement.getType().accept(renderer);
        layout.add(questionWidget.getWidget());
        return layout.getNode();
    }

    @Override
    public Node visit(Conditional statement) {
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
