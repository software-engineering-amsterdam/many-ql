package org.fugazi.qls.ast.widget.widget_types;

import org.fugazi.qls.ast.widget.IWidgetsTypeVisitor;

public class RadioBtnType implements IWidgetType {

    public <T> T accept(IWidgetsTypeVisitor<T> visitor) {
        return visitor.visitRadioBtnType(this);
    }
}
