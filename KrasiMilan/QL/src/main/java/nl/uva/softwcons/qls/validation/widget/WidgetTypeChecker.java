package nl.uva.softwcons.qls.validation.widget;

import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.validation.Checker;
import nl.uva.softwcons.ql.validation.type.Environment;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.segment.SegmentVisitor;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.stylesheet.StylesheetVisitor;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;
import nl.uva.softwcons.qls.validation.widget.error.IncompatibleWidget;

public class WidgetTypeChecker extends Checker implements StylesheetVisitor<Void>, SegmentVisitor<Void> {

    private final Environment typeEnv;

    public WidgetTypeChecker(final Environment env) {
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
        final Type questionType = typeEnv.resolveVariable(question.getId());
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
    public Void visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(page -> page.accept(this));
        return null;
    }

    private void validateWidgetCompatability(final Type type, final StyledWidget widget) {
        if (!widget.getWidgetType().get().isCompatibleWith(type)) {
            addError(new IncompatibleWidget(widget.getLineInfo()));
        }
    }

}
