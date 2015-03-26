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
import nl.uva.softwcons.qls.ast.widget.StylizedType;
import nl.uva.softwcons.qls.validation.widget.error.IncompatibleWidget;

public class WidgetTypeChecker extends Checker implements StylesheetVisitor<Void>, SegmentVisitor<Void> {

    private final Environment typeEnv;

    public WidgetTypeChecker(Environment env) {
        typeEnv = env;
    }

    @Override
    public Void visit(Page page) {
        page.getSegments().forEach(segment -> segment.accept(this));
        for (StylizedType style : page.getStyles()) {
            if (style.hasTypeConflict()) {
                addError(new IncompatibleWidget(page.getLineInfo()));
            }
        }
        return null;
    }

    @Override
    public Void visit(Question question) {
        Type questionType = typeEnv.resolveVariable(question.getId());
        if (question.hasStylizedWidget() && !question.isCompatibleWithWidget(questionType)) {
            addError(new IncompatibleWidget(question.getLineInfo()));
        }
        return null;
    }

    @Override
    public Void visit(Section section) {
        section.getContent().forEach(element -> element.accept(this));
        for (StylizedType style : section.getStyles()) {
            if (style.hasTypeConflict()) {
                addError(new IncompatibleWidget(section.getLineInfo()));
            }
        }

        return null;
    }

    @Override
    public Void visit(Stylesheet stylesheet) {
        stylesheet.getPages().forEach(page -> page.accept(this));
        return null;
    }

}
