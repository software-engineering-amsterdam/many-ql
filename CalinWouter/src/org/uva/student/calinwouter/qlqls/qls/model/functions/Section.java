package org.uva.student.calinwouter.qlqls.qls.model.functions;

import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractComponent;
import org.uva.student.calinwouter.qlqls.qls.model.abstractions.AbstractFormField;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import java.util.LinkedList;
import java.util.List;

public class Section extends AbstractComponent<Section> {
    private String ident;
    private List<AbstractFormField<?>> fields;
    private List<Default> defaultSettings;
    private int arg;

    public String getSectionName(){
        return ident;
    }

    public List<AbstractFormField<?>> getFields() {
        return fields;
    }

    public List<Default> getDefaultSettings() {
        return defaultSettings;
    }

    @Override
    public void caseString(String string) {
        if (arg != 0) {
            super.caseString(string);
            return;
        }
        this.ident = string;
        arg++;
    }

    @Override
    public void caseQuestion(Question question) {
        fields.add(question);
    }

    @Override
    public void caseComputedValue(ComputedValue computedValue) {
        fields.add(computedValue);
    }

    @Override
    public void caseDefault(Default defaultSetting) {
        defaultSettings.add(defaultSetting);
    }

    @Override
    public void apply(IModel iModel) {
        iModel.caseSection(this);
    }

    public Section() {
        fields = new LinkedList<AbstractFormField<?>>();
        defaultSettings = new LinkedList<Default>();
    }
}