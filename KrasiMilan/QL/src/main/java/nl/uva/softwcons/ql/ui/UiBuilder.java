package nl.uva.softwcons.ql.ui;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.form.FormVisitor;
import nl.uva.softwcons.ql.ast.statement.ComputedQuestion;
import nl.uva.softwcons.ql.ast.statement.Conditional;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.statement.Statement;
import nl.uva.softwcons.ql.ast.statement.StatementVisitor;
import nl.uva.softwcons.ql.eval.Evaluator;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;
import nl.uva.softwcons.ql.ui.renderer.Renderer;
import nl.uva.softwcons.ql.ui.widget.Widget;
import nl.uva.softwcons.ql.ui.widget.factory.WidgetFactory;

public class UiBuilder implements FormVisitor<Void>, StatementVisitor<List<QuestionLayout>> {
    private Evaluator evaluator;
    private WidgetFactory widgetFactory;
    private Renderer renderer;

    public UiBuilder(final Form form, final Renderer renderer, final WidgetFactory widgetFactory) {
        this.evaluator = new Evaluator(form);
        this.widgetFactory = widgetFactory;
        this.renderer = renderer;
    }

    public static Node buildFrom(final Form form, final Renderer renderer, final WidgetFactory widgetFactory) {
        final UiBuilder u = new UiBuilder(form, renderer, widgetFactory);
        form.accept(u);

        return renderer.getLayout().getNode();
    }

    @Override
    public Void visit(final Form form) {
        form.getStatements().forEach(s -> s.accept(this));

        visitAndFlatten(form.getStatements()).forEach(l -> {
            renderer.add(l);
        });

        return null;
    }

    @Override
    public List<QuestionLayout> visit(final ComputedQuestion question) {
        final Widget questionWidget = this.widgetFactory.getWidget(question);
        final QuestionLayout layout = new QuestionLayout(question.getId(), question.getLabel(), questionWidget);
        questionWidget.setEditable(false);

        questionWidget.setValue(evaluator.getValue(question.getId()));
        evaluator.addListener(question, (newValue) -> {
            questionWidget.setValue(newValue);
        });

        return Arrays.asList(layout);
    }

    @Override
    public List<QuestionLayout> visit(final Question question) {
        final Widget questionWidget = this.widgetFactory.getWidget(question);
        final QuestionLayout layout = new QuestionLayout(question.getId(), question.getLabel(), questionWidget);

        questionWidget.addListener((newValue) -> {
            evaluator.updateValue(question.getId(), newValue);
        });

        return Arrays.asList(layout);
    }

    @Override
    public List<QuestionLayout> visit(final Conditional conditional) {
        final List<QuestionLayout> layouts = visitAndFlatten(conditional.getQuestions());

        layouts.forEach(layout -> {
            layout.setVisible(evaluator.getValue(conditional).inConditionalContext());
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

}
