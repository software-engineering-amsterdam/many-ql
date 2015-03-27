package nl.uva.softwcons.ql.ui;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

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
import nl.uva.softwcons.ql.eval.Evaluator;
import nl.uva.softwcons.ql.ui.layout.FormLayout;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;
import nl.uva.softwcons.ql.ui.widget.Widget;
import nl.uva.softwcons.ql.ui.widget.WidgetFactory;

public class UiBuilder extends Application implements StatementVisitor<List<QuestionLayout>>, FormVisitor<FormLayout> {
    private Evaluator evaluator;
    private WidgetFactory widgetFactory;

    public UiBuilder() {
    }

    public UiBuilder(final Form form, final WidgetFactory widgetFactory) {
        this.evaluator = new Evaluator(form);
        this.widgetFactory = widgetFactory;
    }

    public static FormLayout buildFrom(final Form form) {
        return form.accept(new UiBuilder(form, new TypeRenderer()));
    }

    @Override
    public FormLayout visit(final Form form) {
        final FormLayout formLayout = new FormLayout(form);
        final List<QuestionLayout> questionLayouts = visitAndFlatten(form.getStatements());

        questionLayouts.forEach(layout -> formLayout.add(layout));

        form.accept(evaluator);

        return formLayout;
    }

    @Override
    public List<QuestionLayout> visit(final ComputedQuestion question) {
        final QuestionLayout layout = new QuestionLayout(question);
        final Widget questionWidget = this.widgetFactory.getWidget(question);
        layout.add(questionWidget.getWidget());

        evaluator.addListener(question, (newValue) -> {
            questionWidget.setValue(newValue);
        });

        return Arrays.asList(layout);
    }

    @Override
    public List<QuestionLayout> visit(final Question question) {
        final QuestionLayout layout = new QuestionLayout(question);
        final Widget questionWidget = this.widgetFactory.getWidget(question);
        layout.add(questionWidget.getWidget());

        questionWidget.addListener((newValue) -> {
            evaluator.updateValue(question.getId(), newValue);
        });

        return Arrays.asList(layout);
    }

    @Override
    public List<QuestionLayout> visit(final Conditional conditional) {
        final List<QuestionLayout> layouts = visitAndFlatten(conditional.getQuestions());

        layouts.forEach(layout -> {
            evaluator.addListener(conditional, (value) -> {
                layout.setVisible(value.inConditionalContext());
            });
        });

        return layouts;
    }

    /**
     * Visits the given statements, collects found question layouts and merges
     * them into a flat resulting list.
     */
    private List<QuestionLayout> visitAndFlatten(final List<? extends Statement> statements) {
        return statements.stream().flatMap(s -> s.accept(this).stream()).collect(toList());
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
