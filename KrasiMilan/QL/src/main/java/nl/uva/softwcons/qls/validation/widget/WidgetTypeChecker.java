package nl.uva.softwcons.qls.validation.widget;

import java.util.List;

import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.validation.Checker;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.segment.SegmentVisitor;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.stylesheet.StylesheetVisitor;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;
import nl.uva.softwcons.qls.ui.QuestionTypeCollector;
import nl.uva.softwcons.qls.validation.widget.error.IncompatibleWidget;

public class WidgetTypeChecker extends Checker implements StylesheetVisitor<List<Error>>, SegmentVisitor<Void> {

    private final QuestionTypeCollector typeEnv;

    public static List<Error> check(final Stylesheet stylesheet, final Form form) {
        QuestionTypeCollector typeCollector = new QuestionTypeCollector(form);
        return stylesheet.accept(new WidgetTypeChecker(typeCollector));
    }

    private WidgetTypeChecker(final QuestionTypeCollector env) {
        this.typeEnv = env;
    }

    @Override
    public Void visit(final Page page) {
        page.getSegments().forEach(segment -> segment.accept(this));

        page.getStyles().forEach((type, widget) -> {
            validateWidgetCompatability(type, widget);
        });

        return null;
    }

    @Override
    public Void visit(final Question question) {
        final Type questionType = typeEnv.get(question.getId());
        if (question.hasWidget()) {
            validateWidgetCompatability(questionType, question.getStyledWidget());
        }

        return null;
    }

    @Override
    public Void visit(final Section section) {
        section.getContent().forEach(element -> element.accept(this));

        section.getStyles().forEach((type, widget) -> {
            validateWidgetCompatability(type, widget);
        });

        return null;
    }

    @Override
    public List<Error> visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(page -> page.accept(this));
        return this.getErrors();
    }

    private void validateWidgetCompatability(final Type type, final StyledWidget widget) {
        if (!widget.getWidgetType().get().isCompatibleWith(type)) {
            addError(new IncompatibleWidget(widget.getLineInfo()));
        }
    }

}
