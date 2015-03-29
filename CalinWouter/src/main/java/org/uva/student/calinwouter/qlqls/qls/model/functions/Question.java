package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractWidget;
import org.uva.student.calinwouter.qlqls.qls.widgets.StyledLabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.qls.model.FieldType;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import java.awt.*;
import java.util.Map;

@SuppressWarnings("unused") // Used through reflection.
public class Question extends AbstractFormField {

    private IWidget createLabelWithWidgetWidget(StaticFields staticFields, StylingSettings stylingSettings, StateWrapper stateWrapper, IWidget embeddedWidget) {
        final String label = staticFields.getLabelForField(identifier);
        return new StyledLabelWithWidgetWidget(label, identifier, embeddedWidget, stateWrapper, stylingSettings);
    }

    @Override
    public Component render(QLSRenderParameters qlsRenderParameters) {

        final StateWrapper stateWrapper = qlsRenderParameters.getStateWrapper();
        final StaticFields staticFields = qlsRenderParameters.getStaticFields();
        final StyleSheet styleSheet = qlsRenderParameters.getStyleSheet();
        final ITypeDescriptor typeDescriptor = staticFields.getTypeOfField(identifier);
        final FieldType fieldType = new FieldType(identifier, typeDescriptor);
        final StylingSettings stylingSettings = styleSheet.deriveStylingSettings(fieldType);
        final AbstractWidget widget = stylingSettings.getWidget();
        final IWidget renderedWidget = widget.render(identifier, qlsRenderParameters);
        final IWidget widgetWrappedWithLabel = createLabelWithWidgetWidget(staticFields, stylingSettings, stateWrapper, renderedWidget);
        return widgetWrappedWithLabel.getWidgetComponent();
    }

    public Question(String identifier) {
        super(identifier);
    }

    public Question(String identifier, Map<String, Object> stylingArguments) {
        super(identifier, stylingArguments);
    }

}
