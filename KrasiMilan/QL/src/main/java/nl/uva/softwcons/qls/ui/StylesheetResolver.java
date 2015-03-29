package nl.uva.softwcons.qls.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.segment.SegmentValueVisitor;
import nl.uva.softwcons.qls.ast.style.Style;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.stylesheet.StylesheetVisitor;
import nl.uva.softwcons.qls.ast.widget.StylizedWidget;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;

public class StylesheetResolver implements StylesheetVisitor<Void>,
        SegmentValueVisitor<Void, Map<Type, StylizedWidget>> {
    private final Map<Identifier, WidgetType> questionWidgetType;
    private final Map<Identifier, Style> questionStyle;
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

    public Style getStyle(final Identifier id) {
        return questionStyle.get(id);
    }

    @Override
    public Void visit(final Stylesheet stylesheet) {
        stylesheet.getPages().forEach(page -> {
            page.accept(this, new HashMap<>());
        });

        return null;
    }

    @Override
    public Void visit(final Page page, final Map<Type, StylizedWidget> styles) {
        page.getSegments().forEach(c -> {
            c.accept(this, inheritStyles(page.getStyles(), styles));
        });

        return null;
    }

    @Override
    public Void visit(final Question question, final Map<Type, StylizedWidget> styles) {
        final Style style = question.getStylizedWidget().getWidgetStyle();
        final Type type = questionType.get(question.getId());

        // TODO
        if (question.getStylizedWidget().getWidgetType().isPresent()) {
            questionWidgetType.put(question.getId(), question.getStylizedWidget().getWidgetType().get());

            questionStyle.put(question.getId(),
                    style.inherit(styles.getOrDefault(type, new StylizedWidget()).getWidgetStyle()));
        } else if (styles.containsKey(type)) {
            questionWidgetType.put(question.getId(), styles.get(type).getWidgetType().get());
            questionStyle.put(question.getId(), styles.get(type).getWidgetStyle());
        }

        return null;
    }

    @Override
    public Void visit(final Section section, final Map<Type, StylizedWidget> styles) {
        section.getContent().forEach(c -> {
            c.accept(this, inheritStyles(section.getStyles(), styles));
        });

        return null;
    }

    private Map<Type, StylizedWidget> inheritStyles(final Map<Type, StylizedWidget> styles,
            final Map<Type, StylizedWidget> parentStyles) {
        final Map<Type, StylizedWidget> mergedStyles = new ConcurrentHashMap<>(styles);

        parentStyles.forEach((type, widget) -> {
            if (mergedStyles.containsKey(type)) {
                final WidgetType currentWidget = mergedStyles.get(type).getWidgetType().get();
                final Style currentStyle = mergedStyles.get(type).getWidgetStyle();
                if (WidgetType.haveSameType(currentWidget, widget.getWidgetType().get())) {
                    final StylizedWidget newStylizedWidget = new StylizedWidget(currentWidget, currentStyle
                            .inherit(widget.getWidgetStyle()));
                    mergedStyles.put(type, newStylizedWidget);
                }
            } else {
                mergedStyles.put(type, widget);
            }
        });

        return mergedStyles;
    }
}
