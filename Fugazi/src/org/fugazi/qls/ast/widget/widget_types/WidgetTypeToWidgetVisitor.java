package org.fugazi.qls.ast.widget.widget_types;

import org.fugazi.qls.ast.widget.*;

public class WidgetTypeToWidgetVisitor implements IWidgetsTypeVisitor<AbstractQLSWidget> {

    public WidgetTypeToWidgetVisitor() {
    }

    public AbstractQLSWidget visitCheckBoxType(CheckBoxType _type) {
        return new QLSCheckBox();
    }

    public AbstractQLSWidget visitRadioBtnType(RadioBtnType _type) {
        return new QLSRadioBtn();
    }

    public AbstractQLSWidget visitDropDownType(DropdownType _type) {
        return new QLSDropdown();
    }

    public AbstractQLSWidget visitSliderType(SliderType _type) {
        return new QLSSlider();
    }

    public AbstractQLSWidget visitSpinBoxType(SpinBoxType _type) {
        return new QLSSpinBox();
    }

    public AbstractQLSWidget visitTextBoxType(TextBoxType _type) {
        return new QLSTextBox();
    }

    public AbstractQLSWidget visitUndefinedWidgetType(UndefinedWidgetType _type) {
        return new QLSUndefinedWidget();
    }
}
