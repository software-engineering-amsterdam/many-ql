package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.qls.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.widgets.computedvalue.LabelWidget;
import org.uva.student.calinwouter.qlqls.qls.model.QLSRenderParameters;

import java.awt.*;
import java.util.Map;

public class ComputedValue extends AbstractFormField {

    public ComputedValue(String identifier) {
        super(identifier);
    }

    @Override
    public Component render(QLSRenderParameters qlsRenderParameters) {
        final QLInterpreter qlInterpreter = qlsRenderParameters.getQlInterpreter();
        final StateWrapper stateWrapper = qlsRenderParameters.getStateWrapper();
        final StaticFields staticFields = qlsRenderParameters.getStaticFields();
        final StyleSheet styleSheet = qlsRenderParameters.getStyleSheet();
        final LabelWidget valueRepresentingLabelWidget = new LabelWidget(identifier, stateWrapper);
        final String computedValueLabel = staticFields.getLabelForField(identifier);
        final LabelWithWidgetWidget labelWithWidgetWidget = new LabelWithWidgetWidget(computedValueLabel,
                identifier, valueRepresentingLabelWidget, stateWrapper);
        return labelWithWidgetWidget.getWidgetComponent();
    }

    public ComputedValue(String ident, Map<String, Object> stylingArguments) {
        super(ident, stylingArguments);
    }

}