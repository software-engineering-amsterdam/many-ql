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
import nl.uva.softwcons.qls.ast.widget.StylizedWidget;
import nl.uva.softwcons.qls.validation.widget.error.IncompatibleWidget;

public class WidgetTypeChecker extends Checker implements StylesheetVisitor<Void>, SegmentVisitor<Void> {

    private final Environment typeEnv;

    public WidgetTypeChecker(final Environment env) {
        this.typeEnv = env;
    }

    @Override
    public Void visit(final Page page) {
        page.getSegments().forEach(segment -> segment.accept(this));
        for (final StylizedWidget style : page.getStyles().values()) {
            if (style.hasTypeConflict()) {
                addError(new IncompatibleWidget(page.getLineInfo()));
            }
        }

        return null;
    }

    @Override
    public Void visit(final Question question) {
        final Type questionType = typeEnv.resolveVariable(question.getId());
        if (question.hasWidget() && !question.isCompatibleWithWidget(questionType)) {
            addError(new IncompatibleWidget(question.getLineInfo()));
        }

        return null;
    }

    @Override
    public Void visit(final Section section) {
        section.getContent().forEach(element -> element.accept(this));
        for (final StylizedType style : section.getStyles()) {
            if (style.hasTypeConflict()) {
                addError(new IncompatibleWidget(section.getLineInfo()));
            }
        }

        return null;
    }

    @Override
    public Void visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(page -> page.accept(this));
        return null;
    }

}
