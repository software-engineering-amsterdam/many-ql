package nl.uva.softwcons.qls.ui;

import java.util.Optional;

import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ui.converter.BooleanToBooleanValueConverter;
import nl.uva.softwcons.ql.ui.converter.StringToNumberValueConverter;
import nl.uva.softwcons.ql.ui.widget.CheckboxWidget;
import nl.uva.softwcons.ql.ui.widget.TextFieldWidget;
import nl.uva.softwcons.ql.ui.widget.Widget;
import nl.uva.softwcons.ql.ui.widget.factory.DefaultWidgetFactory;
import nl.uva.softwcons.ql.ui.widget.factory.WidgetFactory;
import nl.uva.softwcons.qls.ast.style.Style;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ast.widget.type.CheckboxType;
import nl.uva.softwcons.qls.ast.widget.type.DropdownType;
import nl.uva.softwcons.qls.ast.widget.type.RadioButtonType;
import nl.uva.softwcons.qls.ast.widget.type.SliderType;
import nl.uva.softwcons.qls.ast.widget.type.SpinboxType;
import nl.uva.softwcons.qls.ast.widget.type.TextType;
import nl.uva.softwcons.qls.ast.widget.type.WidgetType;
import nl.uva.softwcons.qls.ast.widget.type.WidgetTypeVisitor;
import nl.uva.softwcons.qls.ui.converter.NumberToNumberValueConverter;
import nl.uva.softwcons.qls.ui.converter.StringToBooleanValueConverter;
import nl.uva.softwcons.qls.ui.widget.DropdownWidget;
import nl.uva.softwcons.qls.ui.widget.RadioButtonWidget;
import nl.uva.softwcons.qls.ui.widget.SliderWidget;

public class StylizedWidgetFactory implements WidgetFactory, WidgetTypeVisitor<Widget> {
    private final StylesheetResolver resolver;
    private final WidgetFactory defaultFactory;

    public StylizedWidgetFactory(final Form form, final Stylesheet stylesheet) {
        this.resolver = new StylesheetResolver(stylesheet, form);
        this.defaultFactory = new DefaultWidgetFactory();
    }

    @Override
    public Widget getWidget(Question question) {
        final Optional<WidgetType> questionWidget = resolver.getWidgetType(question.getId());
        final Style questionStyle = resolver.getStyle(question.getId());

        final Widget widget;
        if (questionWidget.isPresent()) {
            widget = questionWidget.get().accept(this);
            widget.getWidget().setStyle(questionStyle.toString()); // TODO
        } else {
            widget = defaultFactory.getWidget(question);
        }

        return widget;
    }

    @Override
    public Widget visit(CheckboxType type) {
        return new CheckboxWidget(type.getYes(), new BooleanToBooleanValueConverter());
    }

    @Override
    public Widget visit(DropdownType type) {
        return new DropdownWidget(type.getYes(), type.getNo(), new StringToBooleanValueConverter(type.getYes(),
                type.getNo()));
    }

    @Override
    public Widget visit(RadioButtonType type) {
        return new RadioButtonWidget(type.getYes(), type.getNo(), new BooleanToBooleanValueConverter());
    }

    @Override
    public Widget visit(SliderType type) {
        return new SliderWidget(type.getStart(), type.getEnd(), type.getStep(), new NumberToNumberValueConverter(
                type.getStart()));
    }

    @Override
    public Widget visit(SpinboxType type) {
        return null; // TODO
    }

    @Override
    public Widget visit(TextType type) {
        return new TextFieldWidget(new StringToNumberValueConverter()); // TODO
    }

}
