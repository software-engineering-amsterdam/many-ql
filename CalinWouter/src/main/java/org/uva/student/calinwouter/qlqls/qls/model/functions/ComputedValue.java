package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

import java.awt.*;
import java.util.Map;

@SuppressWarnings("unused") // Used through reflection.
public class ComputedValue extends AbstractFormField {

    @Override
    public Component render(QLSRenderParameters qlsRenderParameters) {
        final StateWrapper stateWrapper = qlsRenderParameters.getStateWrapper();
        final StaticFields staticFields = qlsRenderParameters.getStaticFields();
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(identifier, stateWrapper);
        final String computedValueLabel = staticFields.getLabelForField(identifier);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(computedValueLabel,
                identifier, valueRepresentingLabelWidget, stateWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    @SuppressWarnings("unused") // Used through reflection.
    public ComputedValue(String identifier) {
        super(identifier);
    }

    @SuppressWarnings("unused") // Used through reflection.
    public ComputedValue(String identifier, Map<String, Object> stylingArguments) {
        super(identifier, stylingArguments);
    }

}