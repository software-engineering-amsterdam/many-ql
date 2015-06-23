package nl.uva.softwcons.qls.ast;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static nl.uva.softwcons.ql.ast.type.DateType.DATE_TYPE;
import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import static nl.uva.softwcons.ql.ast.type.StringType.STRING_TYPE;
import static nl.uva.softwcons.ql.ast.type.UndefinedType.UNDEFINED_TYPE;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import nl.uva.softwcons.generated.QLSBaseVisitor;
import nl.uva.softwcons.generated.QLSParser.CheckboxContext;
import nl.uva.softwcons.generated.QLSParser.DefaultStatementContext;
import nl.uva.softwcons.generated.QLSParser.DropdownContext;
import nl.uva.softwcons.generated.QLSParser.PageContext;
import nl.uva.softwcons.generated.QLSParser.QuestionWithWidgetContext;
import nl.uva.softwcons.generated.QLSParser.QuestionWithoutWidgetContext;
import nl.uva.softwcons.generated.QLSParser.RadioContext;
import nl.uva.softwcons.generated.QLSParser.SectionContext;
import nl.uva.softwcons.generated.QLSParser.SliderContext;
import nl.uva.softwcons.generated.QLSParser.StyleContext;
import nl.uva.softwcons.generated.QLSParser.StylePropertyContext;
import nl.uva.softwcons.generated.QLSParser.StylesheetContext;
import nl.uva.softwcons.generated.QLSParser.TextContext;
import nl.uva.softwcons.generated.QLSParser.WidgetWithStyleContext;
import nl.uva.softwcons.generated.QLSParser.WidgetWithoutStyleContext;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.util.Utils;
import nl.uva.softwcons.qls.ast.segment.Page;
import nl.uva.softwcons.qls.ast.segment.PageSegment;
import nl.uva.softwcons.qls.ast.segment.Question;
import nl.uva.softwcons.qls.ast.segment.Section;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.widgetstyle.Style;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;
import nl.uva.softwcons.qls.ast.widgetstyle.type.CheckboxType;
import nl.uva.softwcons.qls.ast.widgetstyle.type.DropdownType;
import nl.uva.softwcons.qls.ast.widgetstyle.type.RadioButtonType;
import nl.uva.softwcons.qls.ast.widgetstyle.type.SliderType;
import nl.uva.softwcons.qls.ast.widgetstyle.type.TextType;
import nl.uva.softwcons.qls.ast.widgetstyle.type.WidgetType;

import org.antlr.v4.runtime.Token;

public class ASTBuilderVisitor extends QLSBaseVisitor<ASTNode> {

    @Override
    public Stylesheet visitStylesheet(final StylesheetContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
        final List<Page> pages = ctx.page().stream().map(st -> (Page) st.accept(this)).collect(Collectors.toList());

        return new Stylesheet(id, pages);
    }

    @Override
    public Page visitPage(final PageContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
        final List<PageSegment> sections = ctx.pageSegment().stream().map(st -> (PageSegment) st.accept(this))
                .collect(Collectors.toList());
        final Map<Type, StyledWidget> styles = this.constructTypeWithWidgetMap(ctx.defaultStatement());

        return new Page(id, sections, styles);
    }

    @Override
    public Section visitSection(final SectionContext ctx) {
        final String label = Utils.unquote(ctx.STRING().getText());
        final List<PageSegment> content = ctx.pageSegment().stream().map(st -> (PageSegment) st.accept(this))
                .collect(Collectors.toList());
        final Map<Type, StyledWidget> styles = this.constructTypeWithWidgetMap(ctx.defaultStatement());

        return new Section(label, content, styles, extractLineInfo(ctx.STRING().getSymbol()));
    }

    @Override
    public Question visitQuestionWithoutWidget(final QuestionWithoutWidgetContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));

        return new Question(id);
    }

    @Override
    public ASTNode visitQuestionWithWidget(final QuestionWithWidgetContext ctx) {
        final Identifier id = new Identifier(ctx.ID().getText(), extractLineInfo(ctx.ID().getSymbol()));
        final StyledWidget widget = (StyledWidget) ctx.widget().accept(this);

        return new Question(id, widget);
    }

    @Override
    public StyledWidget visitWidgetWithoutStyle(final WidgetWithoutStyleContext ctx) {
        final WidgetType type = (WidgetType) ctx.widgetType().accept(this);

        return new StyledWidget(type);
    }

    @Override
    public StyledWidget visitWidgetWithStyle(final WidgetWithStyleContext ctx) {
        final WidgetType type = (WidgetType) ctx.widgetType().accept(this);
        final Style style = (Style) ctx.style().accept(this);

        return new StyledWidget(type, style);
    }

    @Override
    public Style visitStyle(final StyleContext ctx) {
        final Map<String, String> styles = this.constructStyleProperties(ctx.styleProperty());

        return new Style(styles, extractLineInfo(ctx.start));
    }

    @Override
    public CheckboxType visitCheckbox(final CheckboxContext ctx) {
        return new CheckboxType(Utils.unquote(ctx.yes.getText()), extractLineInfo(ctx.STRING().getSymbol()));
    }

    @Override
    public DropdownType visitDropdown(final DropdownContext ctx) {
        return new DropdownType(Utils.unquote(ctx.yes.getText()), Utils.unquote(ctx.no.getText()), extractLineInfo(ctx
                .STRING().get(0).getSymbol()));
    }

    @Override
    public SliderType visitSlider(final SliderContext ctx) {
        return new SliderType(Double.valueOf(ctx.start.getText()), Double.valueOf(ctx.end.getText()),
                Double.valueOf(ctx.step.getText()), extractLineInfo(ctx.SLIDER().getSymbol()));
    }

    @Override
    public TextType visitText(final TextContext ctx) {
        return new TextType(extractLineInfo(ctx.TEXT().getSymbol()));
    }

    @Override
    public RadioButtonType visitRadio(final RadioContext ctx) {
        return new RadioButtonType(Utils.unquote(ctx.yes.getText()), Utils.unquote(ctx.no.getText()),
                extractLineInfo(ctx.RADIO().getSymbol()));
    }

    private LineInfo extractLineInfo(final Token token) {
        return new LineInfo(token.getLine(), token.getCharPositionInLine());
    }

    private Type getType(final String typeName) {

        switch (typeName) {
        case "boolean":
            return BOOLEAN_TYPE;
        case "number":
            return NUMBER_TYPE;
        case "date":
            return DATE_TYPE;
        case "string":
            return STRING_TYPE;
        default:
            return UNDEFINED_TYPE;
        }
    }

    private Map<Type, StyledWidget> constructTypeWithWidgetMap(final List<DefaultStatementContext> ctx) {
        final Map<Type, StyledWidget> typeWithWidget = new ConcurrentHashMap<>();

        ctx.forEach(c -> {
            final Type questionType = getType(c.type().getText());
            final StyledWidget widget = (StyledWidget) c.widget().accept(this);

            typeWithWidget.put(questionType, widget);
        });

        return typeWithWidget;
    }

    private Map<String, String> constructStyleProperties(final List<StylePropertyContext> ctx) {
        final Map<String, String> styleProperties = new ConcurrentHashMap<>();

        ctx.forEach(c -> {
            final String key = Utils.unquote(c.key.getText());
            final String value = Utils.unquote(c.value().getText());

            styleProperties.put(key, value);
        });

        return styleProperties;
    }

}
