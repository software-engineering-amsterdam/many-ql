package org.fugazi.qls.ast.widget;

import org.fugazi.qls.ast.widget.widget_types.*;

public interface IWidgetsTypeVisitor<T> {
    public T visitCheckBoxType(CheckBoxType _type);
    public T visitRadioBtnType(RadioBtnType _type);
    public T visitDropDownType(DropdownType _type);
    public T visitSliderType(SliderType _type);
    public T visitSpinBoxType(SpinBoxType _type);
    public T visitTextBoxType(TextBoxType _type);
    public T visitUndefinedWidgetType(UndefinedWidgetType _type);
}
