package nl.uva.softwcons.qls.ui;

import java.util.HashMap;
import java.util.Map;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ui.layout.FormLayout;
import nl.uva.softwcons.ql.ui.layout.Layout;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;
import nl.uva.softwcons.ql.ui.renderer.Renderer;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.segment.SegmentValueVisitor;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.stylesheet.StylesheetVisitor;
import nl.uva.softwcons.qls.ui.layout.PageLayout;
import nl.uva.softwcons.qls.ui.layout.SectionLayout;

public class QLSRenderer implements Renderer, StylesheetVisitor<Void>, SegmentValueVisitor<Void, Layout> {
    private final Map<Identifier, QuestionLayout> questionLayouts;
    private final Stylesheet stylesheet;
    private FormLayout formLayout;

    public QLSRenderer(final Stylesheet stylesheet) {
        this.stylesheet = stylesheet;
        this.questionLayouts = new HashMap<>();
    }

    @Override
    public Layout getLayout() {
        formLayout = new FormLayout();
        stylesheet.accept(this);

        return formLayout;
    }

    @Override
    public void add(final QuestionLayout node) {
        this.questionLayouts.put(node.getQuestionId(), node);
    }

    @Override
    public Void visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(p -> {
            p.accept(this, formLayout);
        });

        return null;
    }

    @Override
    public Void visit(final Page page, final Layout layout) {
        final Layout pageLayout = new PageLayout();
        page.getSegments().forEach(s -> {
            s.accept(this, pageLayout);
        });

        layout.add(pageLayout);

        return null;
    }

    @Override
    public Void visit(final Question question, final Layout layout) {
        final QuestionLayout questionLayout = questionLayouts.get(question.getId());
        layout.add(questionLayout);

        return null;
    }

    @Override
    public Void visit(final Section section, final Layout layout) {
        final Layout pageLayout = new SectionLayout();
        section.getContent().forEach(s -> {
            s.accept(this, pageLayout);
        });

        layout.add(pageLayout);
        return null;
    }

}
