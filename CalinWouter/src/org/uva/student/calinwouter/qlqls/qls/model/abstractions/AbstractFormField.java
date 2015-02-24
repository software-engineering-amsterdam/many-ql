package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Default;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// TODO check if invoking this model fails the interpreter.
public abstract class AbstractFormField<T> extends AbstractComponent<T> {
    protected String ident;
    protected HashMap<String, Object> stylingArguments = new HashMap<String, Object>();
    private int arg;

    public String getFieldName() {
        return ident;
    }

    public WidgetSettingsModel getWidgetSettingsModel(String typeReference) throws NoSuchFieldException, IllegalAccessException {
        return WidgetSettingsModel
                .combineSettingsModels(getTypeToWidgetSettingsModel()
                        .getWidgetSettingsModel(typeReference),
                        new WidgetSettingsModel(stylingArguments));
    }

    @Override
    public void caseDefault(Default defaultSetting) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getFieldUses() {
        LinkedList<String> uses = new LinkedList<String>();
        uses.add(ident);
        return uses;
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
    public void caseHashMap(HashMap<String, Object> hashMap) {
        if (arg != 1) {
            super.caseHashMap(hashMap);
            return;
        }
        this.stylingArguments = hashMap;
        arg++;
    }
}
