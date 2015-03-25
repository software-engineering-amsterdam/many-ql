package nl.uva.softwcons.ql.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.eval.Evaluator;
import nl.uva.softwcons.ql.ui.layout.FormLayout;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class UiBuilder extends Application implements StatementVisitor<List<QuestionLayout>>, FormVisitor<FormLayout> {
    private TypeRenderer renderer;
    private Evaluator evaluator;

    public UiBuilder() {
    }

    public UiBuilder(final Form form) {
        this.renderer = new TypeRenderer();
        this.evaluator = new Evaluator(form);
    }

    public static FormLayout buildFrom(final Form form) {
        return form.accept(new UiBuilder(form));
    }

    @Override
    public FormLayout visit(final Form form) {
        final FormLayout formLayout = new FormLayout(form);

        form.getStatements().forEach(statement -> {
            statement.accept(this).forEach(layout -> formLayout.add(layout));
        });

        return formLayout;
    }

    @Override
    public List<QuestionLayout> visit(final ComputedQuestion question) {
        final QuestionLayout layout = new QuestionLayout(question);
        final Widget questionWidget = question.getType().accept(renderer);
        questionWidget.setEditable(false); // TODO this should be in the
                                           // renderer
        layout.add(questionWidget.getWidget());

        evaluator.addListener(question, (newValue) -> questionWidget.setValue(newValue));

        return Arrays.asList(layout);
    }

    @Override
    public List<QuestionLayout> visit(final Question question) {
        final QuestionLayout layout = new QuestionLayout(question);
        final Widget questionWidget = question.getType().accept(renderer);
        layout.add(questionWidget.getWidget());

        questionWidget.addListener((newValue) -> evaluator.updateValue(question.getId(), newValue));

        return Arrays.asList(layout);
    }

    @Override
    public List<QuestionLayout> visit(final Conditional conditional) {
        final List<QuestionLayout> layouts = conditional.getQuestions().stream().flatMap(q -> q.accept(this).stream())
                .collect(Collectors.toList());

        evaluator.addListener(conditional, (value) -> {
            layouts.forEach(l -> l.setVisible(value.inConditionalContext()));
        });

        layouts.forEach(layout -> {
            layout.setVisible(evaluator.getValue(conditional).inConditionalContext());
        });

        return layouts;
    }

    public static void main(final String... args) {
        launch(UiBuilder.class, args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Form f = Questionnaire.build(UiBuilder.class.getResourceAsStream("/form.ql"));
        final Node n = UiBuilder.buildFrom(f).getNode();

        final StackPane root = new StackPane();
        root.getChildren().add(n);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
