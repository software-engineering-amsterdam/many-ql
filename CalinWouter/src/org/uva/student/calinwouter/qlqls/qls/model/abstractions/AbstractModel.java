package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.components.*;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// TODO check if invoking this model fails the interpreter.
public abstract class AbstractModel<T> implements IModel {

    public List<String> getFieldUses() {
        return new LinkedList<String>();
    }

    public List<String> getIllegalWidgetUsages() {
        return new LinkedList<String>();
    }

    @Override
    public void caseHashMap(HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseString(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseInteger(Integer styleSheet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseStyleSheet(StyleSheet styleSheet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseDefault(Default defaultSetting) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void casePage(Page page) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseSection(Section section) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseTypeDescriptor(TypeDescriptor<?> typeDescriptor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseQuestion(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseRadio(Radio radio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseSpinbox(Spinbox radio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseSlider(Slider radio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseCheckbox(Checkbox radio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void caseTextbox(Textbox radio) {
        throw new UnsupportedOperationException();
    }

    public abstract void apply(IModel iModel);
}
