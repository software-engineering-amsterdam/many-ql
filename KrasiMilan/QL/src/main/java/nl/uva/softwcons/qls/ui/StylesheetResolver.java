package nl.uva.softwcons.qls.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.segment.SegmentValueVisitor;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.stylesheet.StylesheetVisitor;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;
import nl.uva.softwcons.qls.ui.style.DefaultStylesMerged;
import nl.uva.softwcons.qls.ui.style.StyleBlock;

public class StylesheetResolver implements StylesheetVisitor<Void>, SegmentValueVisitor<Void, DefaultStylesMerged> {
    private final Map<Identifier, WidgetType> questionWidgetType;
    private final Map<Identifier, StyleBlock> questionStyle;
    private final QuestionTypeCollector questionType;

    public StylesheetResolver(final Stylesheet stylesheet, final Form form) {
        this.questionStyle = new HashMap<>();
        this.questionWidgetType = new HashMap<>();
        this.questionType = new QuestionTypeCollector(form);

        stylesheet.accept(this);
    }

    public Optional<WidgetType> getWidgetType(final Identifier id) {
        return Optional.ofNullable(questionWidgetType.get(id));
    }

    public StyleBlock getStyle(final Identifier id) {
        return questionStyle.get(id);
    }

    @Override
    public Void visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(page -> {
            page.accept(this, new DefaultStylesMerged());
        });

        return null;
    }

    @Override
    public Void visit(final Page page, final DefaultStylesMerged styles) {
        page.getSegments().forEach(c -> {
            c.accept(this, inheritStyles(page.getStyles(), styles));
        });

        return null;
    }

    @Override
    public Void visit(final Question question, final DefaultStylesMerged styles) {
        final StyleBlock styleScope = new StyleBlock(question.getStyledWidget().getWidgetStyle());
        final Optional<WidgetType> widget = question.getStyledWidget().getWidgetType();
        final Type type = questionType.get(question.getId());
        final Identifier questionId = question.getId();

        if (widget.isPresent()) {
            questionWidgetType.put(questionId, widget.get());
            questionStyle.put(questionId, styleScope.inherit(styles.getStyle(type)));
        } else if (styles.contains(type)) {
            questionWidgetType.put(questionId, styles.getWidget(type));
            questionStyle.put(questionId, styles.getStyle(type));
        }

        return null;
    }

    @Override
    public Void visit(final Section section, final DefaultStylesMerged styles) {
        section.getContent().forEach(c -> {
            c.accept(this, inheritStyles(section.getStyles(), styles));
        });

        return null;
    }

    private DefaultStylesMerged inheritStyles(final Map<Type, StyledWidget> styles,
            final DefaultStylesMerged parentStyles) {
        final DefaultStylesMerged mergedStyles = new DefaultStylesMerged(styles);
        mergedStyles.applyParentStyles(parentStyles);

        return mergedStyles;
    }
}
